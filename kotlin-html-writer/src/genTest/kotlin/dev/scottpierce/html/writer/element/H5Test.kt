package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class H5Test {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            h5(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h5 id="test-id" class="test-class">
            </h5>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            h5("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h5 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h5>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            h5(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h5 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h5>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.h5(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <h5 id="test-id" class="test-class">
            </h5>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.h5("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <h5 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h5>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.h5(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <h5 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h5>
            """.trimIndent()
        }
    }

    private fun createWriter(): StringHtmlOutput {
        return StringHtmlOutput(options = WriteOptions(indent = "    "))
    }

    private infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
        kotlin.test.assertEquals(expected(), this.toString())
    }
}
