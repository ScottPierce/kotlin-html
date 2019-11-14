package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class InputTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            input(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <input id="test-id" class="test-class">
            </input>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            input("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <input id="test-id" class="test-class" custom-attr="custom-attr-value">
            </input>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            input(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <input id="test-id" class="test-class" custom-attr="custom-attr-value">
            </input>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.input(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <input id="test-id" class="test-class">
            </input>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.input("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <input id="test-id" class="test-class" custom-attr="custom-attr-value">
            </input>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.input(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <input id="test-id" class="test-class" custom-attr="custom-attr-value">
            </input>
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
