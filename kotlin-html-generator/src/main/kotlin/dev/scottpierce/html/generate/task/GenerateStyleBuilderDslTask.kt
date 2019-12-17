package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.UNIT
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.ATTRIBUTE
import dev.scottpierce.html.generate.model.ATTRIBUTE_LIST
import dev.scottpierce.html.generate.model.Attr
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.GeneratedElement
import dev.scottpierce.html.generate.model.HTML_DSL
import dev.scottpierce.html.generate.model.STYLE_BUILDER_LAMBDA
import dev.scottpierce.html.generate.model.STYLE_BUILDER_STYLE
import java.io.File
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class GenerateStyleBuilderDslTask : Task {
    override val name: String = "Generate Style Builder DSL"

    override suspend fun execute() {
        GlobalScope.launch(Dispatchers.IO) {
            File("${Constants.STYLE_BUILDER_GEN_DIR}").deleteRecursively()
        }.join()

        GeneratedElement.values.map { element ->
            var file: FileSpec.Builder? = null

            if (element.shouldGenStyleBuilderDsl()) {
                file = FileSpec.builder(Constants.ELEMENT_PACKAGE, "${element.tagName.capitalize()}StyleBuilderDsl")
                    .indent("    ")
                    .addComment(Constants.GENERATED_FILE_COMMENT)

                for (type in DslFunction.values()) {
                    file.addFunction(createStyleBuilderDslFunction(element as GeneratedElement.Normal, type))
                }
            }

            val job: Job = if (file == null) {
                CompletableDeferred(true)
            } else {
                (GlobalScope + NonCancellable).launch(Dispatchers.IO) {
                    file.build()
                        .writeTo(Constants.STYLE_BUILDER_GEN_DIR)
                }
            }
            job
        }.joinAll()
    }
}

private fun createStyleBuilderDslFunction(
    element: GeneratedElement.Normal,
    functionType: DslFunction
): FunSpec = FunSpec.builder(element.tagName).apply {
    addModifiers(KModifier.INLINE)
    addAnnotation(HTML_DSL)

    receiver(element.callingContext.contextClassName)

    val paramNames = mutableListOf<String>()

    if (functionType == DslFunction.ATTR_VARARG) {
        paramNames += "attrs"
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE,
                KModifier.VARARG
            ).build()
        )
    } else if (functionType == DslFunction.ATTR_LIST) {
        paramNames += "attrs"
        addParameter(
            ParameterSpec.builder(
                "attrs",
                ATTRIBUTE_LIST
            ).build()
        )
    }

    for (supportedAttr in element.supportedAttributes) {
        val attr: Attr = when (supportedAttr.name) {
            "id" -> {
                Attr.String(
                    name = supportedAttr.name,
                    functionName = supportedAttr.functionName,
                    defaultValue = null,
                    isNullable = false
                )
            }
            "style" -> {
                Attr.Custom(
                    name = "styleBuilder",
                    functionName = "styleBuilder",
                    typeName = STYLE_BUILDER_LAMBDA,
                    defaultValue = null,
                    modifiers = listOf(KModifier.NOINLINE)
                )
            }
            else -> {
                supportedAttr
            }
        }

        paramNames += attr.functionName

        addParameter(
            ParameterSpec.builder(attr.functionName, attr.className).apply {
                if (attr.defaultValue != null) {
                    defaultValue(attr.defaultValue)
                }
                addModifiers(attr.modifiers)
            }.build()
        )
    }

    paramNames += "func"
    addParameter(
        ParameterSpec.builder("func", LambdaTypeName.get(
            receiver = element.childrenContext.contextClassName,
            returnType = UNIT)
        )
            .defaultValue("{}")
            .build()
    )

    addStatement("%M(\"#\$id\", styleBuilder)", STYLE_BUILDER_STYLE)

    addCode("${element.tagName}(")
    paramNames.forEachIndexed { i, param ->
        val isLast = paramNames.lastIndex == i
        val isStyle = param == "styleBuilder"
        val isAttrs = param == "attrs"

        if (isStyle) {
            addCode("style = null")
        } else if (isAttrs && functionType == DslFunction.ATTR_VARARG) {
            addCode("$param = *$param")
        } else {
            addCode("$param = $param")
        }

        if (!isLast) {
            addCode(", ")
        }
    }
    addCode(")")
}.build()

private fun GeneratedElement.shouldGenStyleBuilderDsl(): Boolean {
    return this is GeneratedElement.Normal &&
            supportedAttributes.find { it.name == "id" } != null &&
            supportedAttributes.find { it.name == "style" } != null
}
