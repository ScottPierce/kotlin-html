package dev.scottpierce.html.generate

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File

fun generateElementTests(srcFolder: File): Unit = Element.values.forEach { element ->
    val elementName = element.tagName.capitalize()
    val testName = "${elementName}Tests"

    val file = FileSpec.builder(Constants.ELEMENT_PACKAGE, testName)
        .indent("    ")
        .addComment(Constants.GENERATED_FILE_COMMENT)

    val testType = TypeSpec.classBuilder(testName).apply {

    }.build()

    file.addType(testType)

    file.build()
        .writeTo(srcFolder)
}
