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
inline fun HtmlWriter.h1(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h1", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun HtmlWriter.h1(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h1", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun HtmlWriter.h1(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h1", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun BodyContext.h1(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h1", id, classes, style)
    func()
    writer.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun BodyContext.h1(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h1", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h1")
}

@HtmlDsl
inline fun BodyContext.h1(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h1", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h1")
}
