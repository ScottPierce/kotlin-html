package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class PTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            p(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <p id="test-id" class="test-class">
            </p>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            p("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <p id="test-id" class="test-class" custom-attr="custom-attr-value">
            </p>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            p(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <p id="test-id" class="test-class" custom-attr="custom-attr-value">
            </p>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.p(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <p id="test-id" class="test-class">
            </p>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.p("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <p id="test-id" class="test-class" custom-attr="custom-attr-value">
            </p>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.p(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <p id="test-id" class="test-class" custom-attr="custom-attr-value">
            </p>
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
