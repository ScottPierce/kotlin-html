package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class TrTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            tr(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tr id="test-id" class="test-class">
            </tr>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            tr("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tr id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tr>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            tr(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tr id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tr>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.tr(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tr id="test-id" class="test-class">
            </tr>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.tr("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <tr id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tr>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.tr(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tr id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tr>
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
