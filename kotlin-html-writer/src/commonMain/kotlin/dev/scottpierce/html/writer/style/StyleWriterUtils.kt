package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.BaseHtmlContext
import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
inline fun HtmlWriter.styleSheet(func: StyleSheetContext.() -> Unit) {
    if (!isEmpty) newLine()

    write("<style type=\"text/css\">")
    indent()

    StyleSheetContext(this).apply(func)

    unindent()
    newLine()
    write("</style>")
}

@HtmlDsl
inline fun BaseHtmlContext.styleSheet(func: StyleSheetContext.() -> Unit) = writer.styleSheet(func)

@HtmlDsl
inline fun HtmlWriter.media(selector: String, func: StyleSheetContext.() -> Unit) {
    if (!isEmpty) newLine()

    write("@media ").write(selector)
    if (!options.minifyStyles) write(' ')
    write('{')
    indent()

    StyleSheetContext(this).apply(func)

    unindent()
    newLine()
    write('}')
}

@HtmlDsl
inline fun StyleSheetContext.media(selector: String, func: StyleSheetContext.() -> Unit) = writer.media(selector, func)

@HtmlDsl
inline fun HtmlWriter.style(selector: String, func: StyleLambda) {
    if (!isEmpty) newLine()

    write(selector)
    if (!options.minifyStyles) write(' ')
    write('{')
    indent()

    StyleContext(this).apply(func)

    unindent()
    newLine()
    write('}')
}

@HtmlDsl
inline fun StyleSheetContext.style(selector: String, func: StyleLambda) = writer.style(selector, func)

fun BaseStyleContext.writeStyleProperty(property: String, value: Any) {
    writer.apply {
        if (!isEmpty) newLine()

        write(property).write(':')
        if (!options.minifyStyles) write(' ')
        write(value.toString())
        write(';')
    }
}
