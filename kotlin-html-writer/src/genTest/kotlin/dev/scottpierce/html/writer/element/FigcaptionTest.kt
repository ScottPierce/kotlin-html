package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class FigcaptionTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            figcaption(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <figcaption id="test-id" class="test-class">
            </figcaption>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            figcaption("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <figcaption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </figcaption>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            figcaption(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <figcaption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </figcaption>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.figcaption(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <figcaption id="test-id" class="test-class">
            </figcaption>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.figcaption("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <figcaption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </figcaption>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.figcaption(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <figcaption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </figcaption>
            """.trimIndent()
        }
    }

    private fun createWriter(): StringHtmlOutput {
        return StringHtmlOutput(WriteOptions.readable.copy(indent = "    "))
    }

    private infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
        kotlin.test.assertEquals(expected(), this.toString())
    }
}
