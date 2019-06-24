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
interface P : ContentElement, BodyContent

class PBuilder(
    override val attrs: MutableAttributes
) : P, MutableContentElement {
    override val children: MutableList<Writable> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeElement("p", this)
    }
}

inline fun <T : MutableContentElement> T.p(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: PBuilder.() -> Unit = {}
): P = addChild(id, classes, style, func) { PBuilder(it) }

inline fun <T : MutableContentElement> T.p(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: PBuilder.() -> Unit = {}
): P = addChild(attrs, id, classes, style, func) { PBuilder(it) }

inline fun <T : MutableContentElement> T.p(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: PBuilder.() -> Unit = {}
): P = addChild(attrs, id, classes, style, func) { PBuilder(it) }
