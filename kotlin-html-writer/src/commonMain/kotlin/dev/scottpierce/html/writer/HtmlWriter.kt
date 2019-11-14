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

    override fun write(c: Char) {
        sb.append(c)
    }

    override fun write(code: CharSequence) {
        sb.append(code)
    }

    override fun toString(): String = sb.toString()

    fun asCharSequence(): CharSequence = sb
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
