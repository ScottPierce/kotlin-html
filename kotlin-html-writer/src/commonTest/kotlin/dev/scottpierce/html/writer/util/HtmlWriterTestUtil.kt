package dev.scottpierce.html.writer.util

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.FileContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.StyleContext
import dev.scottpierce.html.writer.style.StyleSheetContext
import dev.scottpierce.html.writer.style.styleSheet

fun writeFile(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: FileContext.() -> Unit
): StringHtmlOutput {
    val writer = StringHtmlOutput(options = options)
    pageWriterScope(writer) {
        FileContext(this).apply(func)
    }
    return writer
}

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: HtmlContext.() -> Unit
): StringHtmlOutput {
    val writer = StringHtmlOutput(options = options)
    pageWriterScope(writer) {
        HtmlContext(this).apply(func)
    }
    return writer
}

fun StringHtmlOutput.assertEquals(expected: String) {
    kotlin.test.assertEquals(expected, this.toString())
}

infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}

fun writeStyle(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleContext.() -> Unit
): StringHtmlOutput {
    val writer = StringHtmlOutput(options = options)
    pageWriterScope(writer) {
        StyleContext(this).apply(func)
    }
    return writer
}

fun writeStyleSheet(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleSheetContext.() -> Unit
): StringHtmlOutput = StringHtmlOutput(options = options).apply {
    styleSheet(func)
}
