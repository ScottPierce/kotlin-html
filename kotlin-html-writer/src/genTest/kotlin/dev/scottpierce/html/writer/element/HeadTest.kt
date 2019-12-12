package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class HeadTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            head(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <head id="test-id" class="test-class">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            head("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <head id="test-id" class="test-class" custom-attr="custom-attr-value">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            head(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <head id="test-id" class="test-class" custom-attr="custom-attr-value">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.head(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <head id="test-id" class="test-class">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.head("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <head id="test-id" class="test-class" custom-attr="custom-attr-value">
            </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.head(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <head id="test-id" class="test-class" custom-attr="custom-attr-value">
            </head>
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
