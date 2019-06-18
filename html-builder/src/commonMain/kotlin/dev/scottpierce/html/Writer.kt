package dev.scottpierce.html

import java.lang.StringBuilder

interface Writer {
    val isDebug: Boolean

    fun write(code: String): Writer
    fun newLine()
    fun indent()
    fun deindent()
}

fun Writer.writeTag(name: String, tag: ParentTag) {
    writeTag(name = name, attributes = tag.attributes, children = tag.children)
}

fun Writer.writeTag(name: String, tag: Tag) {
    writeTag(name = name, attributes = tag.attributes)
}

fun Writer.writeTag(name: String, attributes: Attributes = Attributes.EMPTY, children: List<Tag> = emptyList()) {
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

fun Writer.newLineIfDebug() {
    if (isDebug) {
        newLine()
    }
}

class StringBuilderWriter(override val isDebug: Boolean) : Writer {
    companion object {
        private const val INDENT = "  "
    }

    private val sb = StringBuilder()

    private var indent = 0

    override fun newLine() {
        sb.append('\n')
        for (i in 1..indent) {
            sb.append(INDENT)
        }
    }

    override fun indent() {
        indent++
    }

    override fun deindent() {
        indent--
    }

    override fun write(code: String): Writer {
        sb.append(code)
        return this
    }

    override fun toString(): String = sb.toString()
}