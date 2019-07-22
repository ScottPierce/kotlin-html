package dev.scottpierce.html.util

import dev.scottpierce.html.element.FileContext
import dev.scottpierce.html.element.HtmlContext
import dev.scottpierce.html.style.StyleBuilder
import dev.scottpierce.html.style.StyleSheetBuilder
import dev.scottpierce.html.style.writeStyle
import dev.scottpierce.html.style.writeStyleSheet
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

fun writeStyle(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleBuilder.() -> Unit
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    val style = StyleBuilder()
    style.func()
    writer.writeStyle(style, options.minifyStyles)
    return writer
}

fun writeStyleSheet(
    options: WriteOptions = WriteOptions(indent = "    "),
    func: StyleSheetBuilder.() -> Unit
): StringBuilderHtmlWriter {
    val writer = StringBuilderHtmlWriter(options = options)
    val styleSheet = StyleSheetBuilder()
    styleSheet.func()
    writer.writeStyleSheet(styleSheet)
    return writer
}
