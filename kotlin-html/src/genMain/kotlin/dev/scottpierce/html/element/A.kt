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
inline fun HtmlWriter.a(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("a", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun HtmlWriter.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("a", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun HtmlWriter.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("a", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("a", id, classes, style)
    func()
    writer.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("a", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("a", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("a")
}
