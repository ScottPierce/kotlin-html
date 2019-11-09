package dev.scottpierce.html.generate.task

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import dev.scottpierce.html.generate.Task
import dev.scottpierce.html.generate.model.BASE_STYLE_CONTEXT
import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.GeneratedStyleProperty
import dev.scottpierce.html.generate.model.ParameterType
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class GenerateStylePropertiesTask : Task {
    companion object {
        private val STYLE_PROPERTIES_FILE = File("${Constants.BASE_GEN_DIR}/dev/scottpierce/html/writer/style")
        private val STYLE_PROPERTY_TESTS_FILE = File("${Constants.BASE_GEN_TEST_DIR}/dev/scottpierce/html/writer/style")
        private val WRITE_STYLE_PROPERTY = MemberName("dev.scottpierce.html.writer.style", "writeStyleProperty")
    }

    override val name: String = "Generate Style Properties"

    override suspend fun execute() {
        listOf(
            GlobalScope.launch(Dispatchers.IO) {
                if (!STYLE_PROPERTIES_FILE.exists()) {
                    println("WARNING: ${STYLE_PROPERTIES_FILE.absolutePath} does not exist.")
                }
                STYLE_PROPERTIES_FILE.deleteRecursively()
            },
            GlobalScope.launch(Dispatchers.IO) {
                STYLE_PROPERTY_TESTS_FILE.deleteRecursively()
            }
        ).joinAll()

        GeneratedStyleProperty.values().map { property ->
            generateProperty(property)
        }.map { file ->
            GlobalScope.launch(Dispatchers.IO) {
                file.writeTo(Constants.BASE_GEN_DIR)
            }
        }.joinAll()
    }

    private fun generateProperty(property: GeneratedStyleProperty): FileSpec {
        val file = FileSpec.builder(Constants.STYLE_PACKAGE, property.fileName + "Styles")
            .indent("    ")
            .addAnnotation(
                AnnotationSpec.builder(Suppress::class)
                    .addMember("\"unused\"")
                    .build()
            )
            .addComment(Constants.GENERATED_FILE_COMMENT)

        val generatedClasses: MutableMap<ClassName, TypeSpec> = LinkedHashMap()

        for (setter in property.setters) {
            val functionName = setter.functionName ?: property.propertyName

            file.addFunction(
                FunSpec.builder(functionName).apply {
                    receiver(BASE_STYLE_CONTEXT)
                    // addAnnotation(HTML_DSL)

                    var template = setter.template

                    setter.parameters.forEachIndexed { i, parameter ->
                        val typeName: TypeName = when (parameter.type) {
                            is ParameterType.Exists -> parameter.type.type
                            is ParameterType.Generate -> generateTypeForProperty(
                                generatedClasses = generatedClasses,
                                property = property,
                                parameterType = parameter.type
                            )
                        }

                        val modifiers: MutableList<KModifier> = mutableListOf()
                        if (parameter.isVararg) {
                            modifiers += KModifier.VARARG
                        }

                        addParameter(
                            ParameterSpec.builder(name = parameter.name, type = typeName, modifiers = modifiers).apply {
                                if (parameter.defaultValue != null) {
                                    defaultValue(parameter.defaultValue)
                                }
                            }.build()
                        )

                        template = template.replace("$$i", parameter.name)
                    }

                    val paramBreak: Char = if (template.length > 50) '\n' else ' '

                    addStatement("%M(\"${property.cssName}\",$paramBreak$template)", WRITE_STYLE_PROPERTY)
                }.build()
            )
        }

        for ((_, typeSpec) in generatedClasses) {
            file.addType(typeSpec)
        }

        return file.build()
    }

    private fun generateTypeForProperty(
        generatedClasses: MutableMap<ClassName, TypeSpec>,
        property: GeneratedStyleProperty,
        parameterType: ParameterType.Generate
    ): ClassName {
        val className = ClassName(Constants.STYLE_PACKAGE, property.propertyName.capitalize())

        if (generatedClasses.contains(className)) return className

        generatedClasses[className] = TypeSpec.enumBuilder(className).apply {
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
                val enumName = value.toUpperCase()
                    .replace('-', '_')
                    .replace(' ', '_')

                addEnumConstant(enumName, TypeSpec.anonymousClassBuilder()
                    .addSuperclassConstructorParameter("%S", value)
                    .build())
            }

            addFunction(
                FunSpec.builder("toString")
                    .addModifiers(KModifier.OVERRIDE)
                    .addStatement("return value")
                    .build()
            )
        }.build()

        return className
    }
}
