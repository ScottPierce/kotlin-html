package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import dev.scottpierce.html.write.writeElement

@HtmlTag
interface Head : ContentElement, BodyContent

@HtmlTag
class HeadBuilder(
    override val attrs: MutableAttributes
) : Head, MutableContentElement {
    override val children: MutableList<Writable> = ArrayList(16)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("head", this)
    }
}

inline fun HtmlBuilder.head(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: HeadBuilder.() -> Unit = {}
): Head = addChild(id, classes, style, func) { HeadBuilder(it) }

inline fun HtmlBuilder.head(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: HeadBuilder.() -> Unit = {}
): Head = addChild(attrs, id, classes, style, func) { HeadBuilder(it) }

inline fun HtmlBuilder.head(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: HeadBuilder.() -> Unit = {}
): Head = addChild(attrs, id, classes, style, func) { HeadBuilder(it) }
