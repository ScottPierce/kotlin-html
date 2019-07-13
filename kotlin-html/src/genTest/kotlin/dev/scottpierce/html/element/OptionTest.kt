package dev.scottpierce.html.element

import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class OptionTest {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            option(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <option id="test-id" class="test-class">
            </option>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            option("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <option id="test-id" class="test-class" custom-attr="custom-attr-value">
            </option>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            option(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <option id="test-id" class="test-class" custom-attr="custom-attr-value">
            </option>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()

        SelectContext(writer).option(id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <option id="test-id" class="test-class">
            </option>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        SelectContext(writer).option("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <option id="test-id" class="test-class" custom-attr="custom-attr-value">
            </option>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()

        SelectContext(writer).option(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <option id="test-id" class="test-class" custom-attr="custom-attr-value">
            </option>
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
