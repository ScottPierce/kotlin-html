package dev.scottpierce.html.util

import dev.scottpierce.html.element.FileContext
import dev.scottpierce.html.element.HtmlContext
import dev.scottpierce.html.write.StringBuilderHtmlWriter
import dev.scottpierce.html.write.WriteOptions

fun writeFile(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: FileContext.() -> Unit
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    FileContext(writer).apply(func)
    return writer
}

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: HtmlContext.() -> Unit
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    HtmlContext(writer).apply(func)
    return writer
}

fun StringBuilderHtmlWriter.assertEquals(expected: String) {
    kotlin.test.assertEquals(expected, this.toString())
}

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}

fun createWriter(): StringBuilderHtmlWriter = StringBuilderHtmlWriter(options = WriteOptions(indent = "    "))
