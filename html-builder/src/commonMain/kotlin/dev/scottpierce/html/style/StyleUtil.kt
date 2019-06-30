package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter

fun HtmlWriter.writeStyle(style: Style, isInline: Boolean) {
    for ((property, value) in style.properties) {
        if (value != null) {
            write(property).write(':')

            if (!options.minifyStyles && !isInline) {
                write(' ')
            }

            write(value.toString())
            write(';')
        }
    }
}
