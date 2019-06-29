package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter

fun HtmlWriter.writeStyle(style: Style) {
    for ((property, value) in style.properties) {
        if (value != null) {
            write(property).write(':')

            if (!options.minifyStyles) {
                write(' ')
            }

            write(value.toString())
            write(';')
        }
    }
}
