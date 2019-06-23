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
class Br(
  override val attrs: Attributes
) : Element, BodyContent {
  override fun write(writer: HtmlWriter) {
    writer.writeVoidElement("br", this)
  }
}

fun <T> T.br(
  id: String? = null,
  classes: String? = null,
  style: String? = null
): Br where T : BodyContent, T : ContentElement = addChild(id, classes, style) { Br(it) }

fun <T> T.br(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null
): Br where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style) { Br(it) }

fun <T> T.br(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null
): Br where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style) { Br(it) }
