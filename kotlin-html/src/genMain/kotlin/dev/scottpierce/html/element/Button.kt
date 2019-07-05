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
inline fun HtmlWriter.button(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("button", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun HtmlWriter.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("button", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun HtmlWriter.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("button", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("button", id, classes, style)
    func()
    writer.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("button", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("button", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("button")
}
