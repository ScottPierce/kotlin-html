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
inline fun HtmlWriter.h6(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h6", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h6")
}

@HtmlDsl
inline fun HtmlWriter.h6(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h6", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h6")
}

@HtmlDsl
inline fun HtmlWriter.h6(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("h6", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("h6")
}

@HtmlDsl
inline fun BodyContext.h6(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h6", id, classes, style)
    func()
    writer.writeNormalElementEnd("h6")
}

@HtmlDsl
inline fun BodyContext.h6(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h6", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h6")
}

@HtmlDsl
inline fun BodyContext.h6(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("h6", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("h6")
}
