package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.writeElement

@HtmlTag
class Body(
    override val attrs: Attributes
) : ContentElement, BodyContent {
    override val children: MutableList<Writable> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("body", this)
    }
}

inline fun Html.body(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(id, classes, style, func) { Body(it) }

inline fun Html.body(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { Body(it) }

inline fun Html.body(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { Body(it) }
