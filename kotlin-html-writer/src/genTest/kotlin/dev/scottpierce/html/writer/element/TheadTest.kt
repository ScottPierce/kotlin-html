package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class TheadTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            thead(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <thead id="test-id" class="test-class">
            </thead>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            thead("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <thead id="test-id" class="test-class" custom-attr="custom-attr-value">
            </thead>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            thead(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <thead id="test-id" class="test-class" custom-attr="custom-attr-value">
            </thead>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.thead(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <thead id="test-id" class="test-class">
            </thead>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.thead("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <thead id="test-id" class="test-class" custom-attr="custom-attr-value">
            </thead>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.thead(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <thead id="test-id" class="test-class" custom-attr="custom-attr-value">
            </thead>
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
