package dev.scottpierce.html.element

import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class BodyTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            body(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <body id="test-id" class="test-class">
            </body>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            body("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <body id="test-id" class="test-class" custom-attr="custom-attr-value">
            </body>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            body(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <body id="test-id" class="test-class" custom-attr="custom-attr-value">
            </body>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).body(id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <body id="test-id" class="test-class">
            </body>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).body("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <body id="test-id" class="test-class" custom-attr="custom-attr-value">
            </body>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()

        HtmlContext(writer).body(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <body id="test-id" class="test-class" custom-attr="custom-attr-value">
            </body>
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
