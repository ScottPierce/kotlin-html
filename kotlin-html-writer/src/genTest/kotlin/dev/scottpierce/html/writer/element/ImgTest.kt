package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import kotlin.test.Test

class ImgTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            img(id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <img id="test-id" class="test-class">
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            img("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <img id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            img(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <img id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.img(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <img id="test-id" class="test-class">
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()
        writer.img("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <img id="test-id" class="test-class" custom-attr="custom-attr-value">
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.img(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
                <img id="test-id" class="test-class" custom-attr="custom-attr-value">
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
