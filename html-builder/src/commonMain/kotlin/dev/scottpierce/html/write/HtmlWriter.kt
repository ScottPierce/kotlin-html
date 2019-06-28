package dev.scottpierce.html.write

interface HtmlWriter {
    val options: WriteOptions
    val isEmpty: Boolean

    fun write(c: Char): HtmlWriter
    fun write(code: CharSequence): HtmlWriter
    fun newLine()
    fun indent()
    fun deindent()
}

class StringBuilderHtmlWriter(
    initialCapacity: Int = 128,
    override val options: WriteOptions = WriteOptions.default
) : HtmlWriter {
    private val sb = StringBuilder(initialCapacity)
    private var indent = 0
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    override val isEmpty: Boolean
        get() = sb.isEmpty()

    override fun newLine() {
        if (newLineString != null) {
            sb.append(newLineString)
        }

        if (indentString != null) {
            for (i in 1..indent) {
                sb.append(indentString)
            }
        }
    }

    override fun indent() {
        indent++
    }

    override fun deindent() {
        indent--
    }

    override fun write(c: Char): HtmlWriter {
        sb.append(c)
        return this
    }

    override fun write(code: CharSequence): HtmlWriter {
        sb.append(code)
        return this
    }

    override fun toString(): String = sb.toString()
}

data class WriteOptions(
    val indent: String = "\t",
    val newLine: String = "\n",
    val minifyStyles: Boolean = false
) {
    companion object {
        val default = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "", minifyStyles = true)
    }
}