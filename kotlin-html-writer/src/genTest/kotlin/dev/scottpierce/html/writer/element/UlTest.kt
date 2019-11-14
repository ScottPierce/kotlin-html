package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class UlTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            ul(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <ul id="test-id" class="test-class">
            </ul>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            ul("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <ul id="test-id" class="test-class" custom-attr="custom-attr-value">
            </ul>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            ul(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <ul id="test-id" class="test-class" custom-attr="custom-attr-value">
            </ul>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.ul(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <ul id="test-id" class="test-class">
            </ul>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.ul("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <ul id="test-id" class="test-class" custom-attr="custom-attr-value">
            </ul>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.ul(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <ul id="test-id" class="test-class" custom-attr="custom-attr-value">
            </ul>
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
