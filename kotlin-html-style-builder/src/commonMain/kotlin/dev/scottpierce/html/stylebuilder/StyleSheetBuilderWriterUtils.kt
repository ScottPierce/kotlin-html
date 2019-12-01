package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.Page
import dev.scottpierce.html.writer.element.BaseHtmlContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlWriter.styleSheet(styleSheetBuilder: StyleSheetBuilder) {
    pageWriterScope(this) {
        HtmlContext(this).styleSheet(styleSheetBuilder)
    }
}

@HtmlDsl
fun BaseHtmlContext.styleSheet(styleSheetBuilder: StyleSheetBuilder) {
    page.apply {
        if (!isEmpty) newLine()

        write("<style type=\"text/css\">")
        indent()

        writeStyleSheetBuilder(styleSheetBuilder, this)

        unindent()
        newLine()
        write("</style>")
    }
}

private fun writeStyleSheetBuilder(ssb: StyleSheetBuilder, page: Page) {
    val styles = ssb._styles
    if (styles != null) {
        for ((selector, style) in styles) {
            page.apply {
                newLine()

                write(selector)
                if (!options.minifyStyles) write(' ')
                write('{')
                indent()

                val context = StyleBuilderContext(page, selector, ssb)
                context.style()

                unindent()
                newLine()
                write('}')
            }
        }
    }

    val mediaQueries = ssb._mediaQueries
    if (mediaQueries != null) {
        for ((selector, mediaSsb) in mediaQueries) {
            page.apply {
                newLine()

                write("@media ").write(selector)
                if (!options.minifyStyles) write(' ')
                write('{')
                indent()

                writeStyleSheetBuilder(mediaSsb, page)

                unindent()
                newLine()
                write('}')
            }
        }
    }
}
