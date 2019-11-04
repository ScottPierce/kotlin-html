package dev.scottpierce.html.writer

/**
 * The lowest level interface that designates that it can output code
 */
interface Writable {
    fun write(writer: HtmlWriter)
}
