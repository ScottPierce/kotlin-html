package dev.scottpierce.html.style

import dev.scottpierce.html.element.Context
import dev.scottpierce.html.element.HtmlDsl
import dev.scottpierce.html.write.HtmlWriter

@HtmlDsl
inline fun HtmlWriter.styleSheet(func: StyleSheetContext.() -> Unit) {
    if (!isEmpty) newLine()

    write("<style type=\"text/css\">")
    indent()

    StyleSheetContext(this).apply(func)

    deindent()
    newLine()
    write("</style>")
}

@HtmlDsl
inline fun Context.styleSheet(func: StyleSheetContext.() -> Unit) = writer.styleSheet(func)

@HtmlDsl
inline fun HtmlWriter.mediaQuery(selector: String, func: StyleSheetContext.() -> Unit) {
    if (!isEmpty) newLine()

    write("@media ").write(selector)
    if (!options.minifyStyles) write(' ')
    write('{')
    indent()

    StyleSheetContext(this).apply(func)

    deindent()
    newLine()
    write('}')
}

@HtmlDsl
inline fun HtmlWriter.style(selector: String, func: StyleContext.() -> Unit) {
    if (!isEmpty) {
        newLine()
    }

    write(selector)
    if (!options.minifyStyles) write(' ')
    write('{').newLine()
    indent()

    StyleContext(this).apply(func)

    deindent()
    newLine()
    write('}')
}

@HtmlDsl
inline fun StyleSheetContext.style(selector: String, func: StyleContext.() -> Unit) = writer.style(selector, func)

fun BaseStyleContext.writeStyleProperty(property: String, value: Any) {
    writer.write(property).write(':')
    if (!writer.options.minifyStyles) writer.write(' ')
    writer.write(value.toString())
    writer.write(';')
    writer.newLine()
}
