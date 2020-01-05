package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class CaptionTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            caption(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <caption id="test-id" class="test-class">
            </caption>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            caption("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <caption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </caption>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            caption(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <caption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </caption>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.caption(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <caption id="test-id" class="test-class">
            </caption>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.caption("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <caption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </caption>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.caption(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <caption id="test-id" class="test-class" custom-attr="custom-attr-value">
            </caption>
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
