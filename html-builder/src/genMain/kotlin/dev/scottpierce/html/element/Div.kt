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
class Div(
  override val attrs: Attributes
) : ContentElement, BodyContent {
  override val children: MutableList<Writable> = ArrayList(16)

  override fun write(writer: HtmlWriter) {
    writer.writeElement("div", this)
  }
}

inline fun <T> T.div(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ContentElement = addChild(id, classes, style, func) { Div(it) }

inline fun <T> T.div(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style, func) {
    Div(it) }

inline fun <T> T.div(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style, func) {
    Div(it) }
