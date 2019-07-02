package dev.scottpierce.html.element

import dev.scottpierce.html.style.StyleSheet
import dev.scottpierce.html.style.StyleSheetBuilder
import dev.scottpierce.html.style.writeStyleSheet

fun HeadContext.styleSheet(styleSheet: StyleSheet) {
    writer.newLine()
    writer.write("<style>")
    writer.indent()
    writer.writeStyleSheet(styleSheet)
    writer.deindent()
    writer.newLine()
    writer.write("</style>")
}

fun HeadContext.linkStyleSheet(href: String) {
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"").write(href).write("\">")
}
