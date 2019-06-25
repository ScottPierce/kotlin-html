package dev.scottpierce.html.write

import dev.scottpierce.html.element.ContentElement
import dev.scottpierce.html.element.Element
import dev.scottpierce.html.style.Style

fun HtmlWriter.writeElement(tag: String, element: ContentElement) {
    writeElement(tag = tag, attrs = element.attrs, children = element.children)
}

fun HtmlWriter.writeElement(tag: String, element: Element) {
    writeElement(tag = tag, attrs = element.attrs)
}

fun HtmlWriter.writeElement(tag: String, attrs: Map<String, String?> = mapOf(), children: List<Writable> = emptyList()) {
    write('<').write(tag)

    for (attr in attrs) {
        val key: String = attr.key.also { key ->
            if (key.isEmpty()) {
                throw IllegalArgumentException("Not allowed to have blank attribute for tag $tag.")
            }

            val hasWhitespace = !key.indices.all { !key[it].isWhitespace() }
            if (hasWhitespace) {
                throw IllegalArgumentException("Not allowed to have whitespace characters for attribute '$key' inside" +
                        " tag '$tag'.")
            }
        }
        val value: String? = attr.value

        write(' ')
        if (value == null) {
            write(key)
        } else {
            write(key).write("=\"").write(value).write('"')
        }
    }

    write('>')

    indent()
    for (child in children) {
        newLine()
        child.write(this)
    }
    deindent()

    newLine() // End tag should be on a new line
    write("</").write(tag).write('>')
}

fun HtmlWriter.writeVoidElement(name: String, element: Element) {
    write('<').write(name)
    if (element.attrs.isNotEmpty()) {
        for (attr in element.attrs) {
            write(' ').write(attr.key).write("=\"").write(attr.key).write('"')
        }
    }
    write('>')
}

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
