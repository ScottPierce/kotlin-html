package dev.scottpierce.html.util

import dev.scottpierce.html.Html
import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    builder: () -> Html
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    builder().write(writer)
    return writer
}

fun StringBuilderHtmlWriter.assertEquals(expected: String) {
    kotlin.test.assertEquals(expected, this.toString())
}

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}
