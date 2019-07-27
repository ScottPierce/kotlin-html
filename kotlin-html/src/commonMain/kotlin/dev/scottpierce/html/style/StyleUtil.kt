package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter

fun HtmlWriter.writeStyle(style: Style, isInline: Boolean) {
    var isFirst = true

    for ((property, value) in style.properties) {
        if (value != null) {
            if (isFirst) {
                isFirst = false
            } else {
                if (!isInline) {
                    newLine()
                } else if (!options.minifyStyles) {
                    write(' ')
                }
            }

            write(property).write(':')

            if (!options.minifyStyles && !isInline) {
                write(' ')
            }

            write(value.toString())
            write(';')
        }
    }
}

fun HtmlWriter.writeStyleSheet(styleSheet: StyleSheet) {
    if (!isEmpty) {
        newLine()
    }
    write("<style type=\"text/css\">")
    indent()

    internalWriteStyleSheet(styleSheet)

    deindent()
    newLine()
    write("</style>")
}

private fun HtmlWriter.internalWriteStyleSheet(styleSheet: StyleSheet) {
    val minifyStyles = options.minifyStyles

    for ((selector, styleElement) in styleSheet.styles) {
        newLine() // new line for after a style is written

        when (styleElement) {
            is Style -> {
                write(selector)
                if (!minifyStyles) write(' ')
                write('{')
                indent()
                newLine()
                writeStyle(styleElement, minifyStyles)
                deindent()
                newLine().write('}')
            }

            is MediaQuery -> {
                write("@media ").write(selector)
                if (!minifyStyles) write(' ')
                write('{')
                indent()
                internalWriteStyleSheet(styleElement.styleSheet)
                deindent()
                newLine().write('}')
            }
        }
    }
}
