// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

inline fun HtmlWriter.html(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    this.writeNormalElementStart("html", id, classes, style)
    HtmlContext(this).apply(func)
    this.writeNormalElementEnd("html")
}

inline fun HtmlWriter.html(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    this.writeNormalElementStart("html", id, classes, style, attrs)
    HtmlContext(this).apply(func)
    this.writeNormalElementEnd("html")
}

inline fun HtmlWriter.html(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    this.writeNormalElementStart("html", id, classes, style, attrs)
    HtmlContext(this).apply(func)
    this.writeNormalElementEnd("html")
}

inline fun FileContext.html(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("html", id, classes, style)
    HtmlContext(writer).apply(func)
    writer.writeNormalElementEnd("html")
}

inline fun FileContext.html(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("html", id, classes, style, attrs)
    HtmlContext(writer).apply(func)
    writer.writeNormalElementEnd("html")
}

inline fun FileContext.html(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("html", id, classes, style, attrs)
    HtmlContext(writer).apply(func)
    writer.writeNormalElementEnd("html")
}
