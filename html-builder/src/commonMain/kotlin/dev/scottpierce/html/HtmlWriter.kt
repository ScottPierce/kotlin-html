package dev.scottpierce.html

interface HtmlWriter {
    companion object {
        const val INDENT = "  "
    }

    val isDebug: Boolean

    fun write(code: String): HtmlWriter
    fun newLine()
    fun indent()
    fun deindent()
}

fun HtmlWriter.writeTag(name: String, tag: ParentTag) {
    writeTag(name = name, attributes = tag.attributes, children = tag.children)
}

fun HtmlWriter.writeTag(name: String, tag: Tag) {
    writeTag(name = name, attributes = tag.attributes)
}

fun HtmlWriter.writeTag(name: String, attributes: Attributes = Attributes.EMPTY, children: List<Tag> = emptyList()) {
    write("<$name ")

    for (i in attributes.indices) {
        val key: String = attributes.getKey(i)
        val value: String? = attributes[i]

        if (value == null) {
            write(key).write(" ")
        } else {
            write(key).write("=\"").write(value).write("\"")
        }
    }

    write(">")

    indent()
    for (child in children) {
        newLineIfDebug()
        child.write(this)
    }
    deindent()

    write("</$name>")
}

fun HtmlWriter.newLineIfDebug() {
    if (isDebug) {
        newLine()
    }
}

class StringBuilderHtmlWriter(
    override val isDebug: Boolean = false,
    initialCapacity: Int = 16
) : HtmlWriter {
    private val sb = StringBuilder(initialCapacity)

    private var indent = 0

    override fun newLine() {
        sb.append('\n')
        for (i in 1..indent) {
            sb.append(HtmlWriter.INDENT)
        }
    }

    override fun indent() {
        indent++
    }

    override fun deindent() {
        indent--
    }

    override fun write(html: String): HtmlWriter {
        sb.append(html)
        return this
    }

    override fun toString(): String = sb.toString()
}
