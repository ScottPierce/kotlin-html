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
class Section(
  override val attrs: Attributes
) : ContentElement, BodyContent {
  override val children: MutableList<Writable> = ArrayList(16)

  override fun write(writer: HtmlWriter) {
    writer.writeElement("section", this)
  }
}

inline fun <T> T.section(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ContentElement = addChild(id, classes, style, func) {
    Section(it) }

inline fun <T> T.section(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style, func) {
    Section(it) }

inline fun <T> T.section(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ContentElement = addChild(attrs, id, classes, style, func) {
    Section(it) }
