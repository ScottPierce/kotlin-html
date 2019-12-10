package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
interface HtmlOutput {
    fun write(c: Char)
    fun write(code: CharSequence)
}

class StringHtmlOutput(
    initialCapacity: Int = 128
) : HtmlOutput {
    private val sb = StringBuilder(initialCapacity)

    /**
     * A [CharSequence] of everything that's been written to this [HtmlOutput].
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
