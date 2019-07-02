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
    val minifyStyles = options.minifyStyles

    for ((selector, style) in styleSheet.styles) {
        newLine() // new line for after a style is written

        write(selector)
        if (!minifyStyles) write(' ')
        write('{')
        indent()
        newLine()

        writeStyle(style, minifyStyles)

        deindent()
        newLine().write('}')
    }
}
