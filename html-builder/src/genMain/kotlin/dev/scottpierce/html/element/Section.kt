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
interface Section : ContentElement, BodyContent

class SectionBuilder(
  override val attrs: MutableAttributes
) : Section, MutableContentElement {
  override val children: MutableList<Writable> = ArrayList(16)

  override fun write(writer: HtmlWriter) {
    writer.writeElement("section", this)
  }
}

inline fun <T : MutableContentElement> T.section(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SectionBuilder.() -> Unit = {}
): Section = addChild(id, classes, style, func) { SectionBuilder(it) }

inline fun <T : MutableContentElement> T.section(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SectionBuilder.() -> Unit = {}
): Section = addChild(attrs, id, classes, style, func) { SectionBuilder(it) }

inline fun <T : MutableContentElement> T.section(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: SectionBuilder.() -> Unit = {}
): Section = addChild(attrs, id, classes, style, func) { SectionBuilder(it) }
