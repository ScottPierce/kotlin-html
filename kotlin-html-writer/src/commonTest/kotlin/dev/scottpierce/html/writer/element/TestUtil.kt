package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions

fun createWriter(): StringBuilderHtmlWriter {
    return StringBuilderHtmlWriter(options = WriteOptions(indent = "    "))
}

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}