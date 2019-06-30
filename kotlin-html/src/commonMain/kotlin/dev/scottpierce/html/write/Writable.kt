package dev.scottpierce.html.write

/**
 * The lowest level interface that designates that it can output code
 */
interface Writable {
    fun write(writer: HtmlWriter)
}
