package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class TfootTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            tfoot(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tfoot id="test-id" class="test-class">
            </tfoot>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            tfoot("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tfoot id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tfoot>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            tfoot(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <tfoot id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tfoot>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.tfoot(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tfoot id="test-id" class="test-class">
            </tfoot>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.tfoot("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <tfoot id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tfoot>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.tfoot(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <tfoot id="test-id" class="test-class" custom-attr="custom-attr-value">
            </tfoot>
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
