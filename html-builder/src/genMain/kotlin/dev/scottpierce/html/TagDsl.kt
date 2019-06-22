// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList

@HtmlTag
class Section(
  override val attrs: Attributes
) : ParentTag, BodyContent {
  override val children: MutableList<Tag> = ArrayList(8)

  override fun write(writer: HtmlWriter) {
    writer.writeTag("section", this)
  }
}

inline fun <T> T.section(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ParentTag = addChild(id, classes, style, func) { Section(it) }

inline fun <T> T.section(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ParentTag = addChild(attrs, id, classes, style, func) {
    Section(it) }

inline fun <T> T.section(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Section.() -> Unit = {}
): Section where T : BodyContent, T : ParentTag = addChild(attrs, id, classes, style, func) {
    Section(it) }

@HtmlTag
class Div(
  override val attrs: Attributes
) : ParentTag, BodyContent {
  override val children: MutableList<Tag> = ArrayList(8)

  override fun write(writer: HtmlWriter) {
    writer.writeTag("div", this)
  }
}

inline fun <T> T.div(
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ParentTag = addChild(id, classes, style, func) { Div(it) }

inline fun <T> T.div(
  vararg attrs: Attribute,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ParentTag = addChild(attrs, id, classes, style, func) { Div(it) }

inline fun <T> T.div(
  attrs: List<Attribute>,
  id: String? = null,
  classes: String? = null,
  style: String? = null,
  func: Div.() -> Unit = {}
): Div where T : BodyContent, T : ParentTag = addChild(attrs, id, classes, style, func) { Div(it) }
