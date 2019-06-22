package dev.scottpierce.html.util

import dev.scottpierce.html.DocType
import dev.scottpierce.html.Html
import dev.scottpierce.html.StringBuilderHtmlWriter
import dev.scottpierce.html.WriteOptions

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    docType: DocType = DocType.None,
    builder: Html.() -> Unit = {}
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    Html(docType = docType)
        .apply(builder)
        .write(writer)
    return writer
}

fun StringBuilderHtmlWriter.assertEquals(expected: String) {
    kotlin.test.assertEquals(expected, this.toString())
}

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}
