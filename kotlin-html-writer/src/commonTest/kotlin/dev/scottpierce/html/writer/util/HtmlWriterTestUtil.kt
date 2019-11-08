package dev.scottpierce.html.writer.util

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.FileContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.style.BaseStyleContext
import dev.scottpierce.html.writer.style.InlineStyleContext
import dev.scottpierce.html.writer.style.StyleSheetContext
import dev.scottpierce.html.writer.style.styleSheet

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

fun writeStyle(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: BaseStyleContext.() -> Unit
): StringBuilderHtmlWriter = StringBuilderHtmlWriter(options = options).apply {
    InlineStyleContext(this).apply(func)
}

fun writeStyleSheet(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleSheetContext.() -> Unit
): StringBuilderHtmlWriter = StringBuilderHtmlWriter(options = options).apply {
    styleSheet(func)
}