package dev.scottpierce.html.writer.util

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.StyleContext
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.style.styleSheet
import dev.scottpierce.html.writer.writer

fun writeHtml(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: HtmlContext.() -> Unit
): StringHtmlOutput {
    val output = StringHtmlOutput()
    output.writer {
        HtmlContext(this).apply(func)
    }
    return output
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
    val output = StringHtmlOutput()
    output.writer {
        StyleContext(this).apply(func)
    }
    return output
}

fun writeStyleSheet(
    func: StyleSheetContext.() -> Unit
): StringHtmlOutput = StringHtmlOutput().apply {
    styleSheet(func)
}
