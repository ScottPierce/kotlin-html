package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
interface HtmlWriter {
    val options: WriteOptions
    val isEmpty: Boolean

    fun write(c: Char): HtmlWriter
    fun write(code: String): HtmlWriter
    fun newLine(): HtmlWriter
    fun indent()
    fun unindent()
}

@HtmlDsl
abstract class AbstractHtmlWriter(final override val options: WriteOptions) : HtmlWriter {
    private var indent = 0
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    final override var isEmpty: Boolean = true
        private set

    final override fun newLine(): HtmlWriter {
        if (newLineString != null) {
            write(newLineString)
        }

        if (indentString != null) {
            for (i in 1..indent) {
                write(indentString)
            }
        }

        return this
    }

    final override fun indent() {
        indent++
    }

    final override fun unindent() {
        indent--
    }

    final override fun write(c: Char): HtmlWriter {
        isEmpty = false
        writeChar(c)
        return this
    }

    final override fun write(code: String): HtmlWriter {
        isEmpty = false
        writeString(code)
        return this
    }

    abstract fun writeChar(c: Char)
    abstract fun writeString(code: String)
}

class StringBuilderHtmlWriter(
    initialCapacity: Int = 128,
    options: WriteOptions = WriteOptions.default
) : AbstractHtmlWriter(options) {
    private val sb = StringBuilder(initialCapacity)

    override fun writeChar(c: Char) {
        sb.append(c)
    }

    override fun writeString(code: String) {
        sb.append(code)
    }

    override fun toString(): String = sb.toString()
}

data class WriteOptions(
    val indent: String = "  ",
    val newLine: String = PlatformWriter.lineSeparator,
    val minifyStyles: Boolean = false
) {
    companion object {
        val readable = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "", minifyStyles = true)

        var default = minified
    }
}
