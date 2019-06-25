package dev.scottpierce.html.write

interface HtmlWriter {
    val options: WriteOptions

    fun write(c: Char): HtmlWriter
    fun write(code: String): HtmlWriter
    fun newLine()
    fun indent()
    fun deindent()
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

    override fun write(c: Char): HtmlWriter {
        sb.append(c)
        return this
    }

    override fun write(code: String): HtmlWriter {
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