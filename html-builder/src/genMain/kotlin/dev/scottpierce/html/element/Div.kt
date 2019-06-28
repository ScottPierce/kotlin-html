// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterable

inline fun HtmlWriter.div(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("div", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("div")
}

inline fun HtmlWriter.div(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("div", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("div")
}

inline fun HtmlWriter.div(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("div", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("div")
}

inline fun BodyContext.div(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style)
    func()
    writer.writeNormalElementEnd("div")
}

inline fun BodyContext.div(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("div")
}

inline fun BodyContext.div(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("div")
}
