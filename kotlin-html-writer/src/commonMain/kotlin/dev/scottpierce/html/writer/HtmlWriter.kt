package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
interface HtmlWriter {
    val options: WriteOptions
    fun write(c: Char)
    fun write(code: CharSequence)
}

class StringBuilderHtmlWriter(
    initialCapacity: Int = 128,
    override val options: WriteOptions = WriteOptions.default
) : HtmlWriter {
    private val sb = StringBuilder(initialCapacity)

    /**
     * A [CharSequence] of everything that's been written to this [HtmlWriter].
     *
     * This is exposed to save the underlying data from having to be converted to a [String], especially since the
     * html written can be quite large.
     */
    val charSequence: CharSequence
        get() = sb

    override fun write(c: Char) {
        sb.append(c)
    }

    override fun write(code: CharSequence) {
        sb.append(code)
    }

    fun replace(regex: Regex, replacement: String) {
        val newString = sb.replace(regex, replacement)
        sb.clear()
        sb.append(newString)
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
