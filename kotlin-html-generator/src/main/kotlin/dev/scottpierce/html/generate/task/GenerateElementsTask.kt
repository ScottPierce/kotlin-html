package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.*
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.io.File

class GenerateElementsTask : Task {
    override val name: String = "Generate Elements"

    override suspend fun execute() {
        GlobalScope.launch(Dispatchers.IO) {
            File("${Constants.BASE_GEN_DIR}/dev/scottpierce/html/element").deleteRecursively()
        }.join()

        Element.values.map { element ->
            val elementName = element.tagName.capitalize()

            val file = FileSpec.builder(Constants.ELEMENT_PACKAGE, elementName)
                .indent("    ")
                .addComment(Constants.GENERATED_FILE_COMMENT)

            for (i in 0..1) {
                val isWriter = (i % 2) == 0

                for (type in DslFunction.values()) {
                    file.addFunction(createDslFunction(element, isWriter, type))
                }
            }

            GlobalScope.launch(Dispatchers.IO) {
                file.build()
                    .writeTo(Constants.BASE_GEN_DIR)
            }
        }.joinAll()
    }
}

private fun createDslFunction(
    element: Element,
    isWriter: Boolean,
    functionType: DslFunction
): FunSpec = FunSpec.builder(element.tagName).apply {
    val childrenContext: Context? = element.childrenContext()
    val isParent = childrenContext != null

    val writer: String = if (isWriter) {
        "this"
    } else {
        "writer"
    }

    if (isWriter) {
        receiver(HTML_WRITER)
    } else {
        receiver(element.callingContext.contextClassName)
    }

    // No reason to inline if there is no lambda
    if (isParent) {
        addModifiers(KModifier.INLINE)
    }

    addAnnotation(HTML_DSL)

    if (functionType == DslFunction.ATTR_VARARG) {
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE,
                KModifier.VARARG
            ).build()
        )
    } else if (functionType == DslFunction.ATTR_LIST) {
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE_LIST
            ).build()
        )
    }

    for (attr in element.supportedAttributes) {
        val attrClassName: ClassName = if (attr == "style") {
            STYLE.copy(nullable = true)
        } else {
            STRING.copy(nullable = true)
        }

        addParameter(
            ParameterSpec.builder(attr.snakeCaseToCamelCase(), attrClassName)
                .defaultValue("null")
                .build()
        )
    }

    when (element) {
        is Element.Normal -> {
            addParameter(
                ParameterSpec.builder("func", LambdaTypeName.get(receiver = element.childrenContext.contextClassName, returnType = UNIT))
                    .defaultValue("{}")
                    .build()
            )
        }

        is Element.Void -> {
            // Do Nothing
        }
    }

    // TODO if this is not a writer function, we should call the writer function directly
    // if (!isWriter) {
    //     return
    // }

    val hasOnlyStandardAttributes = STANDARD_ATTRIBUTES.size == element.supportedAttributes.size &&
            STANDARD_ATTRIBUTES.containsAll(element.supportedAttributes)

    // Write Tag Start
    if (hasOnlyStandardAttributes) {
        val tagStartMember: MemberName = when (element) {
            is Element.Normal -> WRITE_NORMAL_ELEMENT_START
            is Element.Void -> WRITE_VOID_ELEMENT
        }

        // Write Tag Start
        addCode("$writer.%M(\"${element.tagName}\", id, classes, style", tagStartMember)

        if (functionType != DslFunction.NO_ATTR) {
            addCode(", attrs")
        }

        addCode(")\n")
    } else {
        val WRITE_TAG = MemberName("dev.scottpierce.html.element", "writeTag")
        val WRITE_STANDARD_ATTRIBUTES = MemberName("dev.scottpierce.html.element", "writeStandardAttributes")
        val WRITE_ATTRIBUTES = MemberName("dev.scottpierce.html.element", "writeAttributes")

        // writeTag("option")
        // writeStandardAttributes(id, classes, style)
        // // writeAttributes(attrs)
        // // TODO write custom attributes
        // write('>')
        // indent()
        // BodyContext(this).apply(func)
        // writeNormalElementEnd("option")

        addStatement("$writer.%M(\"${element.tagName}\")", WRITE_TAG)

        run { // Supported Attributes
            val supportedAttributes = element.supportedAttributes.toMutableList()
            val hasStandardAttributes: Boolean = run {
                var hasStandardAttributes = false

                for (attr in supportedAttributes) {
                    if (STANDARD_ATTRIBUTES.contains(attr)) {
                        hasStandardAttributes = true
                    }
                }

                hasStandardAttributes
            }

            if (hasStandardAttributes) {
                addCode("$writer.%M(", WRITE_STANDARD_ATTRIBUTES)

                if (supportedAttributes.remove("id")) {
                    addCode("id")
                } else {
                    addCode("null")
                }

                if (supportedAttributes.remove("classes")) {
                    addCode(", classes")
                } else {
                    addCode(", null")
                }

                if (supportedAttributes.remove("style")) {
                    addCode(", style")
                } else {
                    addCode(", null")
                }

                addCode(")\n")
            }

            for (remainingAttribute in supportedAttributes) {
                addStatement("""if (${remainingAttribute.snakeCaseToCamelCase()} != null) $writer.write(" $remainingAttribute=\"").write(${remainingAttribute.snakeCaseToCamelCase()}).write('"')""")
            }
        }

        if (functionType != DslFunction.NO_ATTR) {
            addStatement("$writer.%M(attrs)", WRITE_ATTRIBUTES)
        }

        addStatement("$writer.write('>')")
        if (isParent) {
            addStatement("$writer.indent()")
        }
    }

    // Write Content and End
    if (isParent) {
        when {
            isWriter -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
            childrenContext == element.callingContext -> addStatement("func()")
            else -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
        }

        addStatement("$writer.%M(\"${element.tagName}\")", WRITE_NORMAL_ELEMENT_END)
    }
}.build()

enum class DslFunction {
    NO_ATTR,
    ATTR_VARARG,
    ATTR_LIST,
    ;
}

fun Element.childrenContext(): Context? = when (this) {
    is Element.Normal -> childrenContext
    is Element.Void -> null
}