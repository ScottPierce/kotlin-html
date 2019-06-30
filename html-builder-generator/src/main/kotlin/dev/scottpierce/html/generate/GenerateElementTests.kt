package dev.scottpierce.html.generate

import java.io.File

private val TEMPLATE_NORMAL_FILE = File("html-builder/src/commonAndGenTest/kotlin/dev/scottpierce/html/element/DivTest.kt")

fun generateElementTests() {
    File("html-builder/src/genTest/kotlin/dev/scottpierce/html/element/").deleteRecursively()

    val normalTemplate = TEMPLATE_NORMAL_FILE.bufferedReader().readText()

    elementLoop@ for (i in Element.values.indices) {
        val element = Element.values[i]

        // These are the template tests
        when (element.tagName) {
            "div", "br" -> continue@elementLoop
        }

        val capitalizedTag = element.tagName.capitalize()

        when (element) {
            is Element.Normal -> {
                val testString = normalTemplate
                    .replace("Div", capitalizedTag)
                    .replace("div", element.tagName)
                    .replace("BodyContext", element.callingContext.contextClassName.simpleName)

                File("html-builder/src/genTest/kotlin/dev/scottpierce/html/element/${capitalizedTag}Test.kt").apply {
                    parentFile.mkdirs()
                    createNewFile()
                }.bufferedWriter().use {
                    it.write(testString)
                }
            }

            is Element.Void -> {
                val testString = normalTemplate
                    .replace("Br", capitalizedTag)
                    .replace("br", element.tagName)
                    .replace("BodyContext", element.callingContext.contextClassName.simpleName)

                File("html-builder/src/genTest/kotlin/dev/scottpierce/html/element/${capitalizedTag}Test.kt").apply {
                    parentFile.mkdirs()
                    createNewFile()
                }.bufferedWriter().use {
                    it.write(testString)
                }
            }
        }
    }
}
