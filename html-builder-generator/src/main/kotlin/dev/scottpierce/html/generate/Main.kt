package dev.scottpierce.html.generate

import java.io.File

fun main() {
    val sourceFolder = File("./html-builder/src/genMain/kotlin")
    sourceFolder.deleteRecursively()
    generateTags(sourceFolder)
}