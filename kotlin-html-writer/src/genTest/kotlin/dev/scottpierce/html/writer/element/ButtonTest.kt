package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class ButtonTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            button(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <button id="test-id" class="test-class">
            </button>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            button("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <button id="test-id" class="test-class" custom-attr="custom-attr-value">
            </button>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            button(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <button id="test-id" class="test-class" custom-attr="custom-attr-value">
            </button>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.button(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <button id="test-id" class="test-class">
            </button>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.button("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <button id="test-id" class="test-class" custom-attr="custom-attr-value">
            </button>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.button(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <button id="test-id" class="test-class" custom-attr="custom-attr-value">
            </button>
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
