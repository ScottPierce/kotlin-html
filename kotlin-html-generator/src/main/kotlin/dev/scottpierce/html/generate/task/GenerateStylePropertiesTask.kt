package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.BASE_STYLE_CONTEXT
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.GeneratedStyleProperty
import dev.scottpierce.html.generate.model.ParameterType
import dev.scottpierce.html.generate.model.snakeCaseToCamelCase
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class GenerateStylePropertiesTask : Task {
    companion object {
        private val STYLE_PROPERTIES_FILE = File("${Constants.BASE_GEN_DIR}/dev/scotpierce/html/writer/style")
        private val STYLE_PROPERTY_TESTS_FILE = File("${Constants.BASE_GEN_TEST_DIR}/dev/scotpierce/html/writer/style")
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
            .addAnnotation(
                AnnotationSpec.builder(Suppress::class)
                    .addMember("\"unused\"")
                    .build()
            )

        // val propertyTestsFile = FileSpec.builder(Constants.STYLE_PACKAGE, "StylePropertyTests")
        //     .indent("    ")

        propertiesFile.addComment(Constants.GENERATED_FILE_COMMENT)
        // propertyTestsFile.addComment(Constants.GENERATED_FILE_COMMENT)

        // val testClass: TypeSpec.Builder = TypeSpec.classBuilder("StylePropertyTests")

        for (property in GeneratedStyleProperty.values()) {
            generateProperty(propertiesFile, property)
            // generatePropertyTests(testClass, property)
        }

        // propertyTestsFile.addType(testClass.build())

        listOf(
            GlobalScope.launch(Dispatchers.IO) {
                propertiesFile.build()
                    .writeTo(Constants.BASE_GEN_DIR)
            }
            // GlobalScope.launch(Dispatchers.IO) {
            //     propertyTestsFile.build()
            //         .writeTo(Constants.BASE_GEN_TEST_DIR)
            // }
        ).joinAll()
    }

    private val WRITE_STYLE_PROPERTY = MemberName("dev.scottpierce.html.writer.style", "writeStyleProperty")

    private fun generateProperty(file: FileSpec.Builder, property: GeneratedStyleProperty) {
        val functionName = property.propertyName

        for (setter in property.setters) {
            file.addFunction(
                FunSpec.builder(functionName).apply {
                    receiver(BASE_STYLE_CONTEXT)

                    var template = setter.template

                    setter.parameters.forEachIndexed { i, parameter ->
                        val typeName: TypeName = when (parameter.type) {
                            is ParameterType.Exists -> parameter.type.type
                            is ParameterType.Generate -> generateTypeForProperty(file, property, parameter.type)
                        }

                        val modifiers: MutableList<KModifier> = mutableListOf()
                        if (parameter.isVararg) {
                            modifiers += KModifier.VARARG
                        }

                        addParameter(name = parameter.name, type = typeName, modifiers = modifiers)

                        val newTemplateValue = if (setter.isStringTemplate) {
                            "$${parameter.name}"
                        } else {
                            parameter.name
                        }
                        template = template.replace("$$i", newTemplateValue)
                    }

                    addStatement("%M(\"${property.cssName}\", $template)", WRITE_STYLE_PROPERTY)

                }.build()
            )
        }
    }

    private val createdClasses = mutableSetOf<ClassName>()

    private fun generateTypeForProperty(
        file: FileSpec.Builder,
        property: GeneratedStyleProperty,
        parameterType: ParameterType.Generate
    ): ClassName {
        val className = ClassName(Constants.STYLE_PACKAGE, property.propertyName.capitalize())

        if (createdClasses.contains(className)) return className
        createdClasses += className

        file.addType(
            TypeSpec.classBuilder(className).apply {
                addModifiers(KModifier.SEALED)

                primaryConstructor(
                    FunSpec.constructorBuilder()
                        .addParameter("value", STRING)
                        .build()
                )

                addProperty(
                    PropertySpec.builder("value", STRING)
                        .initializer("value")
                        .build()
                )

                for (value in parameterType.values) {
                    addType(
                        TypeSpec.objectBuilder(value.snakeCaseToCamelCase().capitalize())
                            .superclass(className)
                            .addSuperclassConstructorParameter("\"$value\"")
                            .build()
                    )
                }

                addFunction(
                    FunSpec.builder("toString")
                        .addModifiers(KModifier.OVERRIDE)
                        .addStatement("return value")
                        .build()
                )

            }.build()
        )

        return className
    }
}
