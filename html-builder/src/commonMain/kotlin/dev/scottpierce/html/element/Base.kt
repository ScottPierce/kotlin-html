package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable

/**
 * A HTML element
 */
interface Element : Writable {
    val attrs: Attributes
}

/**
 * A HTML element that has content
 */
interface ContentElement : Element {
    val children: MutableList<Writable>

    operator fun String.unaryPlus() {
        children += TextWritable(this)
    }
}

interface Content
interface HeadContent : Content
interface BodyContent : Content

@Suppress("MemberVisibilityCanBePrivate")
class TextWritable(val text: String) : Writable {
    override fun write(writer: HtmlWriter) {
        writer.write(text)
    }
}
