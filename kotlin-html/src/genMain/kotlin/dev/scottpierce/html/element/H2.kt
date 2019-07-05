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
inline fun HtmlWriter.h2(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h2", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun HtmlWriter.h2(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h2", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun HtmlWriter.h2(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h2", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun BodyContext.h2(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h2", id, classes, style)
    func()
    writer.writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun BodyContext.h2(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h2", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun BodyContext.h2(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h2", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h2")
}
