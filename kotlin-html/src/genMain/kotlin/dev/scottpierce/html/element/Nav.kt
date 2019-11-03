// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.InlineStyleLambda
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.nav(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("nav", id, classes, style)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun HtmlWriter.nav(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("nav", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun HtmlWriter.nav(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeNormalElementStart("nav", id, classes, style, attrs)
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun BodyContext.nav(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style)
    func()
    writer.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun BodyContext.nav(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun BodyContext.nav(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("nav")
}
