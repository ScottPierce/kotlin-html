package dev.scottpierce.html.writer.util

import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.StyleContext
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.styleSheet
import dev.scottpierce.html.writer.writer

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    docType: DocType? = null,
    func: HtmlContext.() -> Unit
): StringHtmlOutput {
    return StringHtmlOutput(options).apply {
        html(docType) {
            func()
        }
    }
}

fun write(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: HtmlOutput.() -> Unit
): StringHtmlOutput {
    return StringHtmlOutput(options).apply(func)
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
    val output = StringHtmlOutput(options)
    output.writer {
        StyleContext(this).apply(func)
    }
    return output
}

fun writeStyleSheet(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleSheetContext.() -> Unit
): StringHtmlOutput = StringHtmlOutput(options).apply {
    styleSheet(func)
}
