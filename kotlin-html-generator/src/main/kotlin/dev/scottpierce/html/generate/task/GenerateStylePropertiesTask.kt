package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.ASSERT_EQUALS
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.PropertyType
import dev.scottpierce.html.generate.model.STYLE
import dev.scottpierce.html.generate.model.STYLE_BUILDER
import dev.scottpierce.html.generate.model.STYLE_MEMBER
import dev.scottpierce.html.generate.model.StyleProperty
import dev.scottpierce.html.generate.model.TEST
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.io.File

class GenerateStylePropertiesTask : Task {
    companion object {
        private val STYLE_PROPERTIES_FILE = File("${Constants.BASE_GEN_DIR}/dev/scotpierce/html/style")
        private val STYLE_PROPERTY_TESTS_FILE = File("${Constants.BASE_GEN_TEST_DIR}/dev/scotpierce/html/style")
    }

    override val name: String = "Generate Style Properties"

    override suspend fun execute() {
        listOf(
            GlobalScope.launch(Dispatchers.IO) {
                STYLE_PROPERTIES_FILE.delete()
            },
            GlobalScope.launch(Dispatchers.IO) {
                STYLE_PROPERTY_TESTS_FILE.delete()
            }
        ).joinAll()

        val propertiesFile = FileSpec.builder(Constants.STYLE_PACKAGE, "StyleProperties")
            .indent("    ")

        val propertyTestsFile = FileSpec.builder(Constants.STYLE_PACKAGE, "StylePropertyTests")
            .indent("    ")

        propertiesFile.addComment(Constants.GENERATED_FILE_COMMENT)
        propertyTestsFile.addComment(Constants.GENERATED_FILE_COMMENT)

        val testClass: TypeSpec.Builder = TypeSpec.classBuilder("StylePropertyTests")

        for (property in StyleProperty.values()) {
            generateProperty(propertiesFile, property)
            generatePropertyTests(testClass, property)
        }

        propertyTestsFile.addType(testClass.build())

        listOf(
            GlobalScope.launch(Dispatchers.IO) {
                propertiesFile.build()
                    .writeTo(Constants.BASE_GEN_DIR)
            },
            GlobalScope.launch(Dispatchers.IO) {
                propertyTestsFile.build()
                    .writeTo(Constants.BASE_GEN_TEST_DIR)
            }
        ).joinAll()
    }

    private fun generateProperty(file: FileSpec.Builder, property: StyleProperty) {
        val propertyClassName = property.type.className.copy(nullable = true)

        // val Style.color: Color?
        //     get() = properties["color"] as Color?
        file.addProperty(
            PropertySpec.builder(property.propertyName, propertyClassName)
                .receiver(STYLE)
                .getter(
                    FunSpec.getterBuilder()
                        .addStatement("return properties[\"${property.cssName}\"] as %T", propertyClassName)
                        .build()
                )
                .build()
        )

        // var StyleBuilder.color: Color?
        //     get() = properties["color"] as Color?
        //     set(value) {
        //         properties["color"] = value
        //     }
        file.addProperty(
            PropertySpec.builder(property.propertyName, propertyClassName)
                .mutable(true)
                .receiver(STYLE_BUILDER)
                .getter(
                    FunSpec.getterBuilder()
                        .addStatement("return properties[\"${property.cssName}\"] as %T", propertyClassName)
                        .build()
                )
                .setter(
                    FunSpec.setterBuilder()
                        .addParameter("value", propertyClassName)
                        .addStatement("properties[\"${property.cssName}\"] = value", propertyClassName)
                        .build()
                )
                .build()
        )
    }

    private fun generatePropertyTests(testClass: TypeSpec.Builder, property: StyleProperty) {
        testClass.addFunction(
            FunSpec.builder(property.propertyName).apply {
                addAnnotation(TEST)

                val propertyMember = MemberName("dev.scottpierce.html.style", property.propertyName)

                val expected: CodeBlock = when (property.type) {
                    PropertyType.COLOR -> CodeBlock.of("color(\"#555555\")")
                    PropertyType.DISPLAY -> CodeBlock.of("Display.BLOCK")
                    PropertyType.DIMENSION -> CodeBlock.of("Dimension.Size(1f, DimensionUnit.PX)")
                    PropertyType.ALIGN_ITEMS -> CodeBlock.of("AlignItems.BASELINE")
                    PropertyType.FLEX_DIRECTION -> CodeBlock.of("FlexDirection.COLUMN")
                    PropertyType.JUSTIFY_CONTENT -> CodeBlock.of("JustifyContent.CENTER")
                    PropertyType.INT -> CodeBlock.of("100")
                    PropertyType.STRING -> CodeBlock.of("\"boo\"")
                    PropertyType.POSITION -> CodeBlock.of("Position.STATIC")
                    PropertyType.LIST_STYLE -> CodeBlock.of("ListStyle(ListStyle.Type.DISC)")
                    PropertyType.FLOAT_DIRECTION -> CodeBlock.of("FloatDirection.LEFT")
                    PropertyType.TEXT_TRANSFORM -> CodeBlock.of("TextTransform.NONE")
                    PropertyType.ALIGN_SELF -> CodeBlock.of("AlignSelf.AUTO")
                }

                beginControlFlow("val style = %M", STYLE_MEMBER)
                addCode("%M = ", propertyMember).addCode(expected).addCode("\n")
                addCode("%M(", ASSERT_EQUALS).addCode(expected).addCode(", %M)", propertyMember).addCode("\n")
                endControlFlow()

                addCode("%M(", ASSERT_EQUALS).addCode(expected).addCode(", style.%M)", propertyMember).addCode("\n")
            }.build()
        )
    }
}