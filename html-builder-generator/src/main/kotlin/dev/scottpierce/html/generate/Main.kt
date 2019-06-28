package dev.scottpierce.html.generate

import java.io.File

private val GENERATED_SOURCE_FOLDER = File("./html-builder/src/genMain/kotlin")

fun main() {
    GENERATED_SOURCE_FOLDER.deleteRecursively()

//    generateContexts(GENERATED_SOURCE_FOLDER)
    generateElements(GENERATED_SOURCE_FOLDER)
}
