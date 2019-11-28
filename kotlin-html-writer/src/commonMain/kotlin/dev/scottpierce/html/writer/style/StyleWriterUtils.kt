package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.AmalgamContext
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.StyleContext
import dev.scottpierce.html.writer.StyleLambda
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
inline fun HtmlWriter.styleSheet(func: StyleSheetContext.() -> Unit) {
    pageWriterScope(this) {
        styleSheet(func)
    }
}

@HtmlDsl
inline fun BaseHtmlContext.styleSheet(func: StyleSheetContext.() -> Unit) {
    page.apply {
        if (!isEmpty) newLine()

        write("<style type=\"text/css\">")
        indent()

        (this@styleSheet as StyleSheetContext).apply(func)

        unindent()
        newLine()
        write("</style>")
    }
}

@HtmlDsl
inline fun HtmlWriter.media(selector: String, func: StyleSheetContext.() -> Unit) {
    pageWriterScope(this) {
        media(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.media(selector: String, func: StyleSheetContext.() -> Unit) {
    page.apply {
        if (!isEmpty) newLine()

        write("@media ").write(selector)
        if (!options.minifyStyles) write(' ')
        write('{')
        indent()

        func()

        unindent()
        newLine()
        write('}')
    }
}

@HtmlDsl
inline fun HtmlWriter.style(selector: String, func: StyleLambda) {
    pageWriterScope(this) {
        style(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.style(selector: String, func: StyleLambda) {
    page.apply {
        if (!isEmpty) newLine()

        write(selector)
        if (!options.minifyStyles) write(' ')
        write('{')
        indent()

        (this@style as StyleContext).apply(func)

        unindent()
        newLine()
        write('}')
    }
}

fun BaseStyleContext.writeStyleProperty(property: String, value: Any) {
    page.apply {
        if (!isEmpty) newLine()

        write(property).write(':')
        if (!options.minifyStyles) write(' ')
        write(value.toString())
        write(';')
    }
}
