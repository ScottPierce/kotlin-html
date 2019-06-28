package dev.scottpierce.html.generate

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

fun generateContexts(srcFolder: File) {
    val file = FileSpec.builder(Constants.ELEMENT_PACKAGE, "Context")
        .indent("    ")

    file.addComment(Constants.GENERATED_FILE_COMMENT)

    for (context in Context.values()) {
        file.addType(
            TypeSpec.classBuilder(context.contextClassName.simpleName).apply {
                addAnnotation(HTML_TAG)
                addSuperinterface(Context.className)

                primaryConstructor(
                    FunSpec.constructorBuilder()
                        .addParameter("writer", HTML_WRITER)
                        .build()
                )

                addProperty(
                    PropertySpec.builder("writer", HTML_WRITER, KModifier.OVERRIDE)
                        .initializer("writer")
                        .build()
                )
            }.build()
        )
    }

    file.build()
        .writeTo(srcFolder)
}
