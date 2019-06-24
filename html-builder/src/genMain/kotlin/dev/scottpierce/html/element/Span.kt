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
interface Span : ContentElement, BodyContent

class SpanBuilder(
  override val attrs: MutableAttributes
) : Span, MutableContentElement {
  override val children: MutableList<Writable> = ArrayList(4)

  override fun write(writer: HtmlWriter) {
    writer.writeElement("span", this)
  }
}

inline fun <T : MutableContentElement> T.span(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SpanBuilder.() -> Unit = {}
): Span = addChild(id, classes, style, func) { SpanBuilder(it) }

inline fun <T : MutableContentElement> T.span(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SpanBuilder.() -> Unit = {}
): Span = addChild(attrs, id, classes, style, func) { SpanBuilder(it) }

inline fun <T : MutableContentElement> T.span(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SpanBuilder.() -> Unit = {}
): Span = addChild(attrs, id, classes, style, func) { SpanBuilder(it) }
