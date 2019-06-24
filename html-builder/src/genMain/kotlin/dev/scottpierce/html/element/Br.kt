// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.writeVoidElement
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@HtmlTag
interface Br : Element, BodyContent

class BrBuilder(
    override val attrs: MutableAttributes
) : Br, MutableElement {
    override fun write(writer: HtmlWriter) {
        writer.writeVoidElement("br", this)
    }
}

fun <T : MutableContentElement> T.br(
    id: String? = null,
    classes: String? = null,
    style: String? = null
): Br = addChild(id, classes, style) { BrBuilder(it) }

fun <T : MutableContentElement> T.br(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null
): Br = addChild(attrs, id, classes, style) { BrBuilder(it) }

fun <T : MutableContentElement> T.br(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null
): Br = addChild(attrs, id, classes, style) { BrBuilder(it) }
