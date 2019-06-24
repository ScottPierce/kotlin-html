// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import dev.scottpierce.html.write.writeElement
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList

@HtmlTag
interface Div : ContentElement, BodyContent

class DivBuilder(
    override val attrs: MutableAttributes
) : Div, MutableContentElement {
    override val children: MutableList<Writable> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("div", this)
    }
}

inline fun <T : MutableContentElement> T.div(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: DivBuilder.() -> Unit = {}
): Div = addChild(id, classes, style, func) { DivBuilder(it) }

inline fun <T : MutableContentElement> T.div(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: DivBuilder.() -> Unit = {}
): Div = addChild(attrs, id, classes, style, func) { DivBuilder(it) }

inline fun <T : MutableContentElement> T.div(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: DivBuilder.() -> Unit = {}
): Div = addChild(attrs, id, classes, style, func) { DivBuilder(it) }
