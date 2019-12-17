package dev.scottpierce.html.generate.model

import java.io.File

object Constants {
    const val ELEMENT_PACKAGE = "dev.scottpierce.html.writer.element"
    const val STYLE_PACKAGE = "dev.scottpierce.html.writer.style"
    const val STYLE_BUILDER_PACKAGE = "dev.scottpierce.html.stylebuilder"
    const val GENERATED_FILE_COMMENT = "This file was generated using the `kotlin-html-generator` module. Instead of modifying it, " +
            "modify the\n`html-builder-generator` and run it again."
    val BASE_GEN_DIR = File("kotlin-html-writer/src/genMain/kotlin")
    val STYLE_BUILDER_GEN_DIR = File("kotlin-html-style-builder/src/genMain/kotlin")
    val BASE_GEN_TEST_DIR = File("kotlin-html-writer/src/genTest/kotlin")
}
