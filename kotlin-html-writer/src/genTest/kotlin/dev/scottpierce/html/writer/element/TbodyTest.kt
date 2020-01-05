package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class TbodyTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            tbody(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tbody id="test-id" class="test-class">
            </tbody>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            tbody("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tbody id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tbody>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            tbody(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tbody id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tbody>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.tbody(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tbody id="test-id" class="test-class">
            </tbody>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.tbody("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <tbody id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tbody>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.tbody(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tbody id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tbody>
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
