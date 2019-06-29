package dev.scottpierce.html.element

import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class HeadTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            head(id = "test-id", classes = "test-class")
        } assertEquals {
            """
                <head id="test-id" classes="test-class">
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
                <head id="test-id" classes="test-class" custom-attr="custom-attr-value">
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
                <head id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).head(id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <head id="test-id" classes="test-class">
                </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).head("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <head id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </head>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).head(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")

        writer assertEquals {
            """
                <head id="test-id" classes="test-class" custom-attr="custom-attr-value">
                </head>
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
