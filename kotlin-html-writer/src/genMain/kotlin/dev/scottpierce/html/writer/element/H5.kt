// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.style.InlineStyleLambda
import dev.scottpierce.html.writer.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.h5(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h5", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h5")
}

@HtmlDsl
inline fun HtmlWriter.h5(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h5", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h5")
}

@HtmlDsl
inline fun HtmlWriter.h5(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h5", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h5")
}

@HtmlDsl
inline fun BodyContext.h5(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h5", id, classes, style)
    func()
    writer.writeNormalElementEnd("h5")
}

@HtmlDsl
inline fun BodyContext.h5(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h5", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h5")
}

@HtmlDsl
inline fun BodyContext.h5(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h5", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h5")
}
