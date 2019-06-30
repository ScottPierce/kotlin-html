package dev.scottpierce.html.generate.model

import java.io.File

object Constants {
    const val ELEMENT_PACKAGE = "dev.scottpierce.html.element"
    const val GENERATED_FILE_COMMENT = "This file was generated using the `html-builder-generator` module. Instead of modifying it, " +
            "modify the\n`html-builder-generator` and run it again."
    val BASE_GEN_DIR = File("html-builder/src/genMain/kotlin")
    val BASE_GEN_TEST_DIR = File("html-builder/src/genTest/kotlin")
}