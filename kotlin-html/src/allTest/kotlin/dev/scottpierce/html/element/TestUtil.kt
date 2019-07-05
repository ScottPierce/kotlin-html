package dev.scottpierce.html.element

import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions

fun createWriter(): StringBuilderHtmlWriter {
    return StringBuilderHtmlWriter(options = WriteOptions(indent = "    "))
}

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}