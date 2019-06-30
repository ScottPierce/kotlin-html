package dev.scottpierce.html.generate

import dev.scottpierce.html.generate.model.Constants
import dev.scottpierce.html.generate.model.Element
import java.io.File

private val BASE_TEMPLATE_DIR = File("html-builder/src/commonAndGenTest/kotlin/dev/scottpierce/html/element")
private val TEMPLATE_NORMAL_FILE = File("$BASE_TEMPLATE_DIR/DivTest.kt")
private val TEMPLATE_VOID_FILE = File("$BASE_TEMPLATE_DIR/BrTest.kt")

fun generateElementTests() {
    File("${Constants.BASE_GEN_TEST_DIR}/dev/scottpierce/html/element/").deleteRecursively()

    val normalTemplate = TEMPLATE_NORMAL_FILE.bufferedReader().readText()
    val voidTemplate = TEMPLATE_VOID_FILE.bufferedReader().readText()

    elementLoop@ for (i in Element.values.indices) {
        val element = Element.values[i]

        // These are the template tests. Generating them again would be duplicate
        when (element.tagName) {
            "div", "br" -> continue@elementLoop
        }

        val capitalizedTag = element.tagName.capitalize()

        val testString: String = when (element) {
            is Element.Normal -> {
                normalTemplate
                    .replace("Div", capitalizedTag)
                    .replace("div", element.tagName)
                    .replace("BodyContext", element.callingContext.contextClassName.simpleName)
            }

            is Element.Void -> {
                voidTemplate
                    .replace("Br", capitalizedTag)
                    .replace("br", element.tagName)
                    .replace("BodyContext", element.callingContext.contextClassName.simpleName)
            }
        }

        File("${Constants.BASE_GEN_TEST_DIR}/dev/scottpierce/html/element/${capitalizedTag}Test.kt").apply {
            parentFile.mkdirs()
            createNewFile()
        }.bufferedWriter().use {
            it.write(testString)
        }
    }
}
