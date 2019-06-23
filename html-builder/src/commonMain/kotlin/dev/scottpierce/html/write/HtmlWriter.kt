package dev.scottpierce.html.write

import dev.scottpierce.html.element.ContentElement
import dev.scottpierce.html.element.Element

interface HtmlWriter {
    val options: WriteOptions

    fun write(code: String): HtmlWriter
    fun newLine()
    fun indent()
    fun deindent()
}

fun HtmlWriter.writeElement(tag: String, element: ContentElement) {
    writeElement(tag = tag, attrs = element.attrs, children = element.children)
}

fun HtmlWriter.writeElement(tag: String, element: Element) {
    writeElement(tag = tag, attrs = element.attrs)
}

fun HtmlWriter.writeElement(tag: String, attrs: Map<String, String?> = mapOf(), children: List<Writable> = emptyList()) {
    write("<$tag")

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

        write(" ")
        if (value == null) {
            write(key)
        } else {
            write(key).write("=\"").write(value).write("\"")
        }
    }

    write(">")

    indent()
    for (child in children) {
        newLine()
        child.write(this)
    }
    deindent()

    newLine() // End tag should be on a new line
    write("</$tag>")
}

fun HtmlWriter.writeVoidElement(name: String, element: Element) {
    write("<").write(name)
    if (element.attrs.isNotEmpty()) {
        for (attr in element.attrs) {
            write(" ").write(attr.key).write("=\"").write(attr.key).write("\"")
        }
    }
    write(">")
}

class StringBuilderHtmlWriter(
    initialCapacity: Int = 16,
    override val options: WriteOptions = WriteOptions.default
) : HtmlWriter {
    private val sb = StringBuilder(initialCapacity)

    private var indent = 0

    override fun newLine() {
        sb.append(options.newLine)
        for (i in 1..indent) {
            sb.append(options.indent)
        }
    }

    override fun indent() {
        indent++
    }

    override fun deindent() {
        indent--
    }

    override fun write(code: String): HtmlWriter {
        sb.append(code)
        return this
    }

    override fun toString(): String = sb.toString()
}

data class WriteOptions(
    val indent: String = "\t",
    val newLine: String = "\n"
) {
    companion object {
        val default = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "")
    }
}