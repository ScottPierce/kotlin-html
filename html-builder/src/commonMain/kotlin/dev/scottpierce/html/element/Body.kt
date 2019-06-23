package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import dev.scottpierce.html.write.writeElement

@HtmlTag
interface Body : ContentElement, BodyContent

class BodyBuilder(
    override val attrs: MutableAttributes
) : Body, MutableContentElement {
    override val children: MutableList<Writable> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("body", this)
    }
}

inline fun HtmlBuilder.body(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyBuilder.() -> Unit = {}
): Body = addChild(id, classes, style, func) { BodyBuilder(it) }

inline fun HtmlBuilder.body(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyBuilder.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { BodyBuilder(it) }

inline fun HtmlBuilder.body(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyBuilder.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { BodyBuilder(it) }
