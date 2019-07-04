package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.UNIT
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.ATTRIBUTE
import dev.scottpierce.html.generate.model.ATTRIBUTE_LIST
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.Context
import dev.scottpierce.html.generate.model.Element
import dev.scottpierce.html.generate.model.HTML_WRITER
import dev.scottpierce.html.generate.model.STYLE
import dev.scottpierce.html.generate.model.WRITE_NORMAL_ELEMENT_END
import dev.scottpierce.html.generate.model.WRITE_NORMAL_ELEMENT_START
import dev.scottpierce.html.generate.model.WRITE_VOID_ELEMENT
import dev.scottpierce.html.generate.model.snakeCaseToCamelCase
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

    val attributeParametersString: String = run {
        val sb = StringBuilder()

        val remainingAttributes: MutableList<String> = element.supportedAttributes.toMutableList()

        if (remainingAttributes.contains("id")) {
            remainingAttributes.remove("id")
            sb.append("id")
        } else {
            sb.append("null")
        }

        sb.append(", ")

        if (element.supportedAttributes.contains("classes")) {
            remainingAttributes.remove("classes")
            sb.append("classes")
        } else {
            sb.append("null")
        }

        sb.append(", ")

        if (element.supportedAttributes.contains("style")) {
            remainingAttributes.remove("style")
            sb.append("style")
        } else {
            sb.append("null")
        }

        // TODO This is inefficient. This can avoid array allocation by writing custom write functions
        if (remainingAttributes.isNotEmpty()) {
            sb.append(", ")

            sb.append("arrayOf(")
            var isFirst = true

            if (functionType == DslFunction.ATTR_VARARG) {
                isFirst = false
                sb.append("*attrs")
            } else if (functionType == DslFunction.ATTR_LIST) {
                isFirst = false
                sb.append("*attrs.toTypedArray()")
            }

            for (attr in remainingAttributes) {
                if (isFirst) {
                    isFirst = false
                } else {
                    sb.append(", ")
                }
                sb.append("\"$attr\" to ${attr.snakeCaseToCamelCase()}")
            }

            sb.append(")")
        } else {
            if (functionType != DslFunction.NO_ATTR) {
                sb.append(", attrs")
            }
        }

        sb.toString()
    }

    when (element) {
        is Element.Normal -> {
            if (functionType == DslFunction.NO_ATTR) {
                addStatement("$writer.%M(\"${element.tagName}\", $attributeParametersString)",
                    WRITE_NORMAL_ELEMENT_START)
            } else {
                addStatement("$writer.%M(\"${element.tagName}\", $attributeParametersString)",
                    WRITE_NORMAL_ELEMENT_START)
            }

            if (isParent) {
                when {
                    isWriter -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
                    childrenContext == element.callingContext -> addStatement("func()")
                    else -> addStatement("%T($writer).apply(func)", childrenContext!!.contextClassName)
                }
            }

            addStatement("$writer.%M(\"${element.tagName}\")", WRITE_NORMAL_ELEMENT_END)
        }

        is Element.Void -> {
            if (functionType == DslFunction.NO_ATTR) {
                addStatement("$writer.%M(\"${element.tagName}\", $attributeParametersString)", WRITE_VOID_ELEMENT)
            } else {
                addStatement("$writer.%M(\"${element.tagName}\", $attributeParametersString)", WRITE_VOID_ELEMENT)
            }
        }
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