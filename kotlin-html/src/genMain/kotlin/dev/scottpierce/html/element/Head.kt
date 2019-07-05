// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.head(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    this.writeNormalElementStart("head", id, classes, style)
    HeadContext(this).apply(func)
    this.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlWriter.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    this.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(this).apply(func)
    this.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlWriter.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    this.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(this).apply(func)
    this.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}
