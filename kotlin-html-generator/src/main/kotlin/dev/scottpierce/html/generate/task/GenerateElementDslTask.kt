@file:Suppress("UnnecessaryVariable")

package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.UNIT
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.ATTRIBUTE
import dev.scottpierce.html.generate.model.ATTRIBUTE_LIST
import dev.scottpierce.html.generate.model.Attr
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.Context
import dev.scottpierce.html.generate.model.GeneratedElement
import dev.scottpierce.html.generate.model.HTML_DSL
import dev.scottpierce.html.generate.model.HTML_WRITER
import dev.scottpierce.html.generate.model.STANDARD_ATTRIBUTES
import dev.scottpierce.html.generate.model.TO_WRITER
import dev.scottpierce.html.generate.model.WRITE_NORMAL_ELEMENT_END
import dev.scottpierce.html.generate.model.WRITE_NORMAL_ELEMENT_START
import dev.scottpierce.html.generate.model.WRITE_VOID_ELEMENT
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class GenerateElementDslTask : Task {
    override val name: String = "Generate Elements DSL"

    override suspend fun execute() {
        GlobalScope.launch(Dispatchers.IO) {
            File("${Constants.BASE_GEN_DIR}/dev/scottpierce/html/writer/element").deleteRecursively()
        }.join()

        GeneratedElement.values.map { element ->
            val writerFile = FileSpec.builder(Constants.ELEMENT_PACKAGE, "${element.tagName.capitalize()}Dsl")
                .indent("    ")
                .addComment(Constants.GENERATED_FILE_COMMENT)

            for (i in 0..1) {
                val isOutput = (i % 2) == 0

                for (type in DslFunction.values()) {
                    writerFile.addFunction(createDslFunction(element, isOutput, type))
                }
            }

            (GlobalScope + NonCancellable).launch {
                launch(Dispatchers.IO) {
                    writerFile.build()
                        .writeTo(Constants.BASE_GEN_DIR)
                }
            }
        }.joinAll()
    }
}

val WRITE_TAG = MemberName("dev.scottpierce.html.writer.element", "writeTag")
val WRITE_STANDARD_ATTRIBUTES = MemberName("dev.scottpierce.html.writer.element", "writeStandardAttributes")
val WRITE_ATTRIBUTES = MemberName("dev.scottpierce.html.writer.element", "writeAttributes")

private fun createDslFunction(
    element: GeneratedElement,
    isOutput: Boolean,
    functionType: DslFunction
): FunSpec = FunSpec.builder(element.tagName).apply {
    val childrenContext: Context? = element.childrenContext()
    val isParent = childrenContext != null

    val writer: String = if (isOutput) "this" else "writer"

    if (isOutput) {
        receiver(HTML_WRITER)
    } else {
        receiver(element.callingContext.contextClassName)
    }

    // No reason to inline if there is no lambda
    val isInline: Boolean = isParent && !isOutput

    if (isInline) {
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
        val filteredModifiers = attr.modifiers.filter {
            isInline && it === KModifier.NOINLINE
        }

        addParameter(
            ParameterSpec.builder(attr.functionName, attr.className).apply {
                if (attr.defaultValue != null) {
                    defaultValue(attr.defaultValue)
                }
                addModifiers(filteredModifiers)
            }.build()
        )
    }

    when (element) {
        is GeneratedElement.Normal -> {
            addParameter(
                ParameterSpec.builder("func", LambdaTypeName.get(
                    receiver = element.childrenContext.contextClassName,
                    returnType = UNIT)
                )
                    .defaultValue("{}")
                    .build()
            )
        }

        is GeneratedElement.Void -> {
            // Do Nothing
        }
    }

    // TODO if this is not a writer function, we should call the writer function directly
    // if (!isWriter) {
    //     return
    // }

    val hasOnlyStandardAttributes = STANDARD_ATTRIBUTES.size == element.supportedAttributes.size &&
            STANDARD_ATTRIBUTES.containsAll(element.supportedAttributes)

    if (isOutput) {
        beginControlFlow("%M", TO_WRITER)
    }

    // Write Tag Start
    if (hasOnlyStandardAttributes) {
        val tagStartMember: MemberName = when (element) {
            is GeneratedElement.Normal -> WRITE_NORMAL_ELEMENT_START
            is GeneratedElement.Void -> WRITE_VOID_ELEMENT
        }

        // Write Tag Start
        addCode("$writer.%M(\"${element.tagName}\", id, classes, style", tagStartMember)

        if (functionType != DslFunction.NO_ATTR) {
            addCode(", attrs")
        }

        addCode(")\n")
    } else {
        addStatement("$writer.%M(\"${element.tagName}\")", WRITE_TAG)

        run { // Supported Attributes
            val supportedAttributes: MutableList<Attr> = element.supportedAttributes.toMutableList()

            val hasStandardAttributes: Boolean = run {
                var hasStandardAttributes = false

                for (attr in element.supportedAttributes) {
                    if (STANDARD_ATTRIBUTES.contains(attr)) {
                        hasStandardAttributes = true
                    }
                }

                hasStandardAttributes
            }

            if (hasStandardAttributes) {
                addCode("$writer.%M(", WRITE_STANDARD_ATTRIBUTES)

                if (supportedAttributes.remove(Attr.ID)) {
                    addCode("id")
                } else {
                    addCode("null")
                }

                if (supportedAttributes.remove(Attr.CLASSES)) {
                    addCode(", classes")
                } else {
                    addCode(", null")
                }

                if (supportedAttributes.remove(Attr.STYLE)) {
                    addCode(", style")
                } else {
                    addCode(", null")
                }

                addCode(")\n")
            }

            for (remainingAttribute in supportedAttributes) {
                val attrCodeName = remainingAttribute.functionName

                when (remainingAttribute) {
                    is Attr.Boolean -> {
                        addStatement("""if ($attrCodeName) $writer.write(%S)""", " ${remainingAttribute.name}")
                    }

                    else -> {
                        addStatement("""if ($attrCodeName != null) $writer.write(%S).write($attrCodeName).write('"')""", " ${remainingAttribute.name}=\"")
                    }
                }
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
            isOutput -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
            childrenContext == element.callingContext -> addStatement("func()")
            else -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
        }

        addStatement("$writer.%M(\"${element.tagName}\")", WRITE_NORMAL_ELEMENT_END)
    }

    if (isOutput) {
        endControlFlow()
    }
}.build()

enum class DslFunction {
    NO_ATTR,
    ATTR_VARARG,
    ATTR_LIST,
    ;
}

fun GeneratedElement.childrenContext(): Context? = when (this) {
    is GeneratedElement.Normal -> childrenContext
    is GeneratedElement.Void -> null
}
