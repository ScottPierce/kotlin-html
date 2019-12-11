package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class BrTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            br(id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <br id="test-id" class="test-class">
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            br("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <br id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            br(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <br id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.br(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <br id="test-id" class="test-class">
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()
        writer.br("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <br id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.br(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <br id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    private fun createWriter(): StringHtmlOutput {
        return StringHtmlOutput()
    }

    private infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
        kotlin.test.assertEquals(expected(), this.toString())
    }
}
