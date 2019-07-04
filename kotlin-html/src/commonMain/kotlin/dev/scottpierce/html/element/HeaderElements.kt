package dev.scottpierce.html.element

import dev.scottpierce.html.style.StyleSheet
import dev.scottpierce.html.style.writeStyleSheet

@HtmlDsl
fun HeadContext.styleSheet(styleSheet: StyleSheet) {
    writer.newLine()
    writer.write("<style>")
    writer.indent()
    writer.writeStyleSheet(styleSheet)
    writer.deindent()
    writer.newLine()
    writer.write("</style>")
}

@HtmlDsl
fun HeadContext.linkStyleSheet(href: String) {
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"").write(href).write("\">")
}
