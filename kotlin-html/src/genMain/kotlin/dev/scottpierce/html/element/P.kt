// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterable

inline fun HtmlWriter.p(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("p", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("p")
}

inline fun HtmlWriter.p(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("p", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("p")
}

inline fun HtmlWriter.p(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("p", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("p")
}

inline fun BodyContext.p(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("p", id, classes, style)
    func()
    writer.writeNormalElementEnd("p")
}

inline fun BodyContext.p(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("p", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("p")
}

inline fun BodyContext.p(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("p", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("p")
}
