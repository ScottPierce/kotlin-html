package dev.scottpierce.html.element

import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class HtmlTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            html(id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <html id="test-id" classes="test-class">
                </html>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            html("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <html id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </html>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            html(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <html id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </html>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()

        FileContext(writer).html(id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <html id="test-id" classes="test-class">
                </html>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        FileContext(writer).html("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <html id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </html>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()

        FileContext(writer).html(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <html id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </html>
            """.trimIndent()
        }
    }

    private fun createWriter(): StringBuilderHtmlWriter {
        return StringBuilderHtmlWriter(options = WriteOptions(indent = "    "))
    }

    private infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
        kotlin.test.assertEquals(expected(), this.toString())
    }
}
