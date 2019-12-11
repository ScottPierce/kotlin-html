package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class H3Test {
    @Test
    fun writerNoCustomAttributeTest() {
        createWriter().apply {
            h3(id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h3 id="test-id" class="test-class">
            </h3>
            """.trimIndent()
        }
    }

    @Test
    fun writerVarArgAttributeTest() {
        createWriter().apply {
            h3("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h3 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h3>
            """.trimIndent()
        }
    }

    @Test
    fun writerListAttributeTest() {
        createWriter().apply {
            h3(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        } assertEquals {
            """
            <h3 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h3>
            """.trimIndent()
        }
    }

    @Test
    fun contextNoCustomAttributeTest() {
        val writer = createWriter()
        writer.h3(id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <h3 id="test-id" class="test-class">
            </h3>
            """.trimIndent()
        }
    }

    @Test
    fun contextVarArgAttributeTest() {
        val writer = createWriter()

        writer.h3("custom-attr" to "custom-attr-value", id = "test-id", classes = "test-class")

        writer assertEquals {
            """
            <h3 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h3>
            """.trimIndent()
        }
    }

    @Test
    fun contextListAttributeTest() {
        val writer = createWriter()
        writer.h3(attrs = listOf("custom-attr" to "custom-attr-value"), id = "test-id", classes = "test-class")
        writer assertEquals {
            """
            <h3 id="test-id" class="test-class" custom-attr="custom-attr-value">
            </h3>
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
