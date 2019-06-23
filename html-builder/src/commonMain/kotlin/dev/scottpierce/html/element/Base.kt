package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable

/**
 * A HTML element
 */
interface Element : Writable {
    val attrs: Attributes
}

interface MutableElement : Element {
    override val attrs: MutableAttributes
}

interface ContentElement : Element {
    val children: List<Writable>
}

/**
 * A HTML element that has content
 */
interface MutableContentElement : ContentElement, MutableElement {
    override val children: MutableList<Writable>

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
