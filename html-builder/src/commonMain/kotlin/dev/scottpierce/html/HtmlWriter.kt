package dev.scottpierce.html

interface HtmlWriter {
    companion object {
        const val INDENT = "    "
    }

    val isDebug: Boolean

    fun write(code: String): HtmlWriter
    fun newLine()
    fun indent()
    fun deindent()
}

fun HtmlWriter.writeTag(name: String, tag: ParentTag) {
    writeTag(name = name, attrs = tag.attrs, children = tag.children)
}

fun HtmlWriter.writeTag(name: String, tag: Tag) {
    writeTag(name = name, attrs = tag.attrs)
}

fun HtmlWriter.writeTag(name: String, attrs: Map<String, String?> = mapOf(), children: List<Tag> = emptyList()) {
    write("<$name")

    for (attr in attrs) {
        val key: String = attr.key.also { key ->
            if (key.isEmpty()) {
                throw IllegalArgumentException("Not allowed to have blank attribute for tag $name.")
            }

            val hasWhitespace = !key.indices.all { !key[it].isWhitespace() }
            if (hasWhitespace) {
                throw IllegalArgumentException("Not allowed to have whitespace characters for attribute '$key' inside" +
                        " tag '$name'.")
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
        newLineIfDebug()
        child.write(this)
    }
    deindent()

    newLineIfDebug() // End tag should be on a new line
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
