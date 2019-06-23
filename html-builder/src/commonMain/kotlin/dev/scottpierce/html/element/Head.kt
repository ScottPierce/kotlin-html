package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.writeElement

@HtmlTag
class Head(
    override val attrs: Attributes
) : ContentElement, BodyContent {
    override val children: MutableList<Writable> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("head", this)
    }
}

inline fun Html.head(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Head.() -> Unit = {}
): Head = addChild(id, classes, style, func) { Head(it) }

inline fun Html.head(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Head.() -> Unit = {}
): Head = addChild(attrs, id, classes, style, func) { Head(it) }

inline fun Html.head(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Head.() -> Unit = {}
): Head = addChild(attrs, id, classes, style, func) { Head(it) }
