// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.div(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("div", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("div")
    }
}

@HtmlDsl
inline fun HtmlWriter.div(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("div", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("div")
    }
}

@HtmlDsl
inline fun HtmlWriter.div(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("div", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("div")
    }
}

@HtmlDsl
inline fun BodyContext.div(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style)
    func()
    writer.writeNormalElementEnd("div")
}

@HtmlDsl
inline fun BodyContext.div(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("div")
}

@HtmlDsl
inline fun BodyContext.div(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("div", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("div")
}
