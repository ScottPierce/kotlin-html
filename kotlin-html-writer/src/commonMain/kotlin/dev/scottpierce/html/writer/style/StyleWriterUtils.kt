package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.BaseHtmlContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
inline fun HtmlWriter.styleSheet(func: StyleSheetContext.() -> Unit) {
    pageWriterScope(this) {
        HtmlContext(this).styleSheet(func)
    }
}

@HtmlDsl
inline fun BaseHtmlContext.styleSheet(func: StyleSheetContext.() -> Unit) {
    writer.apply {
        if (!isEmpty) newLine()

        write("<style type=\"text/css\">")
        indent()

        StyleSheetContext(this).apply(func)

        unindent()
        newLine()
        write("</style>")
    }
}

@HtmlDsl
inline fun HtmlWriter.media(selector: String, func: StyleSheetContext.() -> Unit) {
    pageWriterScope(this) {
        StyleSheetContext(this).media(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.media(selector: String, func: StyleSheetContext.() -> Unit) {
    writer.apply {
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
}

@HtmlDsl
inline fun HtmlWriter.style(selector: String, func: StyleLambda) {
    pageWriterScope(this) {
        StyleSheetContext(this).style(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.style(selector: String, func: StyleLambda) {
    writer.apply {
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
}

fun BaseStyleContext.writeStyleProperty(property: String, value: Any) {
    writer.apply {
        if (!isEmpty) newLine()

        write(property).write(':')
        if (!options.minifyStyles) write(' ')
        write(value.toString())
        write(';')
    }
}
