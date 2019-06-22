package dev.scottpierce.html.generate

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import java.io.File

private val TMutableMap = ClassName("kotlin.collections", "MutableMap")
private val TMutableList = ClassName("kotlin.collections", "MutableList")
private val TArrayList = ClassName("kotlin.collections", "ArrayList")
private val HtmlTag = ClassName("dev.scottpierce.html", "HtmlTag")
private val ParentTag = ClassName("dev.scottpierce.html", "ParentTag")
private val HeadContent = ClassName("dev.scottpierce.html", "HeadContent")
private val BodyContent = ClassName("dev.scottpierce.html", "BodyContent")
private val TTag = ClassName("dev.scottpierce.html", "Tag")
private val HtmlWriter = ClassName("dev.scottpierce.html", "HtmlWriter")
private val TUnit = ClassName("kotlin", "Unit")
private val TString = ClassName("kotlin", "String")
private val Attribute = ClassName("dev.scottpierce.html", "Attribute")
private val Attributes = ClassName("dev.scottpierce.html", "Attributes")
private val ArrayAttributes = ClassName("dev.scottpierce.html", "ArrayAttributes")
private val AttributeMutableMap = TMutableMap.parameterizedBy(TString, TString.copy(nullable = true))

private val filePackage = "dev.scottpierce.html"

fun generateTags(srcFolder: File) {
    val file = FileSpec.builder(filePackage, "TagDsl")

    file.addComment("This file was generated using the `html-builder-generator` module. Instead of modifying it, " +
            "modify the\n`html-builder-generator` and run it again.")

    file.addAnnotation(
        AnnotationSpec.builder(Suppress::class)
            .addMember("\"unused\"")
            .build()
    )

    for (tag in Tag.values()) {
        val tagClassName = ClassName(filePackage, tag.tagName.capitalize())

        // Generate DSL Class
        val tagType = TypeSpec.classBuilder(tagClassName).apply {
            addAnnotation(HtmlTag)

            if (tag.isParent) {
                addSuperinterface(ParentTag)
            }

            when (tag.contentType) {
                ContentType.HEAD -> addSuperinterface(HeadContent)
                ContentType.BODY -> addSuperinterface(BodyContent)
            }

            primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameter("attrs", Attributes)
                    .build()
            )

            addProperty(
                PropertySpec.builder("attrs", Attributes, KModifier.OVERRIDE)
                    .initializer("attrs")
                    .build()
            )

            if (tag.isParent) {
                addProperty(
                    PropertySpec.builder("children", TMutableList.parameterizedBy(TTag), KModifier.OVERRIDE)
                        .initializer("%T(8)", TArrayList)
                        .build()
                )
            }

            addFunction(
                FunSpec.builder("write")
                    .addModifiers(KModifier.OVERRIDE)
                    .addParameter("writer", HtmlWriter)
                    .addCode("writer.writeTag(\"${tag.tagName}\", this)\n")
                    .build()
            )
        }.build()


        file.addType(tagType)

        fun createDslFunction(hasAttrs: Boolean): FunSpec {
            val contentType: ClassName = when (tag.contentType) {
                ContentType.HEAD -> HeadContent
                ContentType.BODY -> BodyContent
            }

            return FunSpec.builder(tag.tagName)
                .addTypeVariable(
                    TypeVariableName.invoke(
                        name = "T",
                        bounds = *arrayOf(contentType, ParentTag)
                    )
                )
                .receiver(TypeVariableName.invoke("T"))
                .addModifiers(KModifier.INLINE)
                .apply {
                    if (hasAttrs) {
                        addParameter(
                            ParameterSpec.builder(
                                "attrs",
                                Attribute,
                                KModifier.VARARG
                            ).build()
                        )
                    }
                }
                .apply {

                    for (attr in tag.supportedAttributes) {
                        addParameter(
                            ParameterSpec.builder(attr, TString.copy(nullable = true))
                                .defaultValue("null")
                                .build()
                        )
                    }

                }
                .addParameter(
                    ParameterSpec.builder("func", LambdaTypeName.get(receiver = tagClassName, returnType = TUnit))
                        .defaultValue("{}")
                        .build()
                )
                .addCode("""
                    return addChild(${if (hasAttrs) "attrs, " else ""}id, classes, style, func) { %T(it) }
                """.trimIndent(), tagClassName)
                .addCode("\n")
                .returns(tagClassName)
                .build()
        }

        // Generate DSL function
        file.addFunction(createDslFunction(true))
        file.addFunction(createDslFunction(false))
    }

    file.build()
        .writeTo(srcFolder)
}
