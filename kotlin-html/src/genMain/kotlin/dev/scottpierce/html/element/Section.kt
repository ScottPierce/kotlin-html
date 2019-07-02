// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.Iterable

inline fun HtmlWriter.section(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

inline fun HtmlWriter.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

inline fun HtmlWriter.section(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("section", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("section")
}

inline fun BodyContext.section(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style)
    func()
    writer.writeNormalElementEnd("section")
}

inline fun BodyContext.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("section")
}

inline fun BodyContext.section(
    attrs: Iterable<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("section")
}
