package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class SpanTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            span(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <span id="test-id" class="test-class">
            </span>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            span("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <span id="test-id" class="test-class" custom-attr="custom-attr-value">
            </span>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            span(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <span id="test-id" class="test-class" custom-attr="custom-attr-value">
            </span>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.span(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <span id="test-id" class="test-class">
            </span>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.span("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <span id="test-id" class="test-class" custom-attr="custom-attr-value">
            </span>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.span(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <span id="test-id" class="test-class" custom-attr="custom-attr-value">
            </span>
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
