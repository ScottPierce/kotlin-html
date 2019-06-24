package dev.scottpierce.html.generate

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File
import java.lang.RuntimeException

// ################################
// ###### Start Class Names
// ################################
private val MutableMap = ClassName("kotlin.collections", "MutableMap")
private val List = ClassName("kotlin.collections", "List")
private val MutableList = ClassName("kotlin.collections", "MutableList")
private val ArrayList = ClassName("kotlin.collections", "ArrayList")
private val HtmlTag = ClassName("dev.scottpierce.html.element", "HtmlTag")
private val TElement = ClassName("dev.scottpierce.html.element", "Element")
private val TMutableElement = ClassName("dev.scottpierce.html.element", "MutableElement")
private val ContentElement = ClassName("dev.scottpierce.html.element", "ContentElement")
private val MutableContentElement = ClassName("dev.scottpierce.html.element", "MutableContentElement")
private val HeadContent = ClassName("dev.scottpierce.html.element", "HeadContent")
private val BodyContent = ClassName("dev.scottpierce.html.element", "BodyContent")
private val HtmlWriter = ClassName("dev.scottpierce.html.write", "HtmlWriter")
private val TUnit = ClassName("kotlin", "Unit")
private val TString = ClassName("kotlin", "String")
private val Attribute = ClassName("dev.scottpierce.html.element", "Attribute")
private val Attributes = ClassName("dev.scottpierce.html.element", "Attributes")
private val MutableAttributes = ClassName("dev.scottpierce.html.element", "MutableAttributes")
private val ArrayAttributes = ClassName("dev.scottpierce.html", "ArrayAttributes")
private val AttributeMutableMap = MutableMap.parameterizedBy(TString, TString.copy(nullable = true))
private val WritableMutableList = MutableList.parameterizedBy(ClassName("dev.scottpierce.html.write", "Writable"))
private val AttributeList = List.parameterizedBy(Attribute)
// ################################
// ###### End Class Names
// ################################

val writeElement = MemberName("dev.scottpierce.html.write", "writeElement")
val writeVoidElement = MemberName("dev.scottpierce.html.write", "writeVoidElement")

private val filePackage = "dev.scottpierce.html.element"

fun generateTags(srcFolder: File) {
    for (element in Element.values()) {
        val elementName = element.tagName.capitalize()
        val elementClassName = ClassName(filePackage, elementName)
        val elementBuilderName = "${elementName}Builder"
        val elementBuilderClassName = ClassName(filePackage, elementBuilderName)

        val file = FileSpec.builder(filePackage, elementName)
            .indent("    ")

        file.addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember("\"unused\"")
                .build()
        )

        file.addComment("This file was generated using the `html-builder-generator` module. Instead of modifying it, " +
                "modify the\n`html-builder-generator` and run it again.")

        val isParent: Boolean = element.type !is ElementType.Void

        // Generate functionally immutable interface
        val elementType = TypeSpec.interfaceBuilder(elementClassName).apply {
            addAnnotation(HtmlTag)

            if (isParent) {
                addSuperinterface(ContentElement)
            } else {
                addSuperinterface(TElement)
            }

            when (element.contentType) {
                ContentType.HEAD -> addSuperinterface(HeadContent)
                ContentType.BODY -> addSuperinterface(BodyContent)
            }
        }.build()

        // Generate mutable builder class
        val elementBuilderType = TypeSpec.classBuilder(elementBuilderClassName).apply {
            addSuperinterface(elementClassName)

            if (isParent) {
                addSuperinterface(MutableContentElement)
            } else {
                addSuperinterface(TMutableElement)
            }

            primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameter("attrs", MutableAttributes)
                    .build()
            )

            addProperty(
                PropertySpec.builder("attrs", MutableAttributes, KModifier.OVERRIDE)
                    .initializer("attrs")
                    .build()
            )

            if (isParent) {
                addProperty(
                    PropertySpec.builder("children", WritableMutableList, KModifier.OVERRIDE)
                        .initializer("%T(${element.childrenListInitialCapacity})", ArrayList)
                        .build()
                )
            }

            addFunction(
                FunSpec.builder("write")
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameter("writer", HtmlWriter)
                    .apply {
                        when (element.type) {
                            is ElementType.Normal -> addCode("writer.%M(\"${element.tagName}\", this)\n", writeElement)
                            is ElementType.Void -> addCode("writer.%M(\"${element.tagName}\", this)\n", writeVoidElement)
                            else -> throw RuntimeException("Unsupported Tag Type")
                        }
                    }
                    .build()
            )
        }.build()

        file.addType(elementType)
        file.addType(elementBuilderType)

        fun createDslFunction(type: DslFunction): FunSpec {
            val contentType: ClassName = when (element.contentType) {
                ContentType.HEAD -> HeadContent
                ContentType.BODY -> BodyContent
            }

            return FunSpec.builder(element.tagName)
                .addTypeVariable(
                    TypeVariableName.invoke(
                        name = "T",
                        bounds = *arrayOf(MutableContentElement)
                    )
                )
                .receiver(TypeVariableName.invoke("T"))
                .apply {
                    val isParent = element.type !is ElementType.Void

                    // No reason to inline if there is no lambda
                    if (isParent) {
                        addModifiers(KModifier.INLINE)
                    }

                    if (type == DslFunction.ATTR_VARARG) {
                        addParameter(
                            ParameterSpec.builder(
                                "attrs",
                                Attribute,
                                KModifier.VARARG
                            ).build()
                        )
                    } else if (type == DslFunction.ATTR_LIST) {
                        addParameter(
                            ParameterSpec.builder(
                                "attrs",
                                AttributeList
                            ).build()
                        )
                    }

                    for (attr in element.supportedAttributes) {
                        addParameter(
                            ParameterSpec.builder(attr, TString.copy(nullable = true))
                                .defaultValue("null")
                                .build()
                        )
                    }

                    if (isParent) {
                        addParameter(
                            ParameterSpec.builder("func", LambdaTypeName.get(receiver = elementBuilderClassName, returnType = TUnit))
                                .defaultValue("{}")
                                .build()
                        )
                    }

                    when (type) {
                        DslFunction.NONE -> {
                            addCode("return addChild(id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
                        }
                        DslFunction.ATTR_LIST -> {
                            addCode("return addChild(attrs, id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
                        }
                        DslFunction.ATTR_VARARG -> {
                            addCode("return addChild(attrs, id, classes, style${if (isParent) ", func" else ""}) { %T(it) }", elementBuilderClassName)
                        }
                    }

                    addCode("\n")
                }
                .returns(elementClassName)
                .build()
        }

        // Generate DSL function
        file.addFunction(createDslFunction(DslFunction.NONE))
        file.addFunction(createDslFunction(DslFunction.ATTR_VARARG))
        file.addFunction(createDslFunction(DslFunction.ATTR_LIST))

        file.build()
            .writeTo(srcFolder)
    }
}

private enum class DslFunction {
    NONE, ATTR_VARARG, ATTR_LIST
}