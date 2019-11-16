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
inline fun HtmlWriter.body(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("body", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("body")
    }
}

@HtmlDsl
inline fun HtmlWriter.body(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("body", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("body")
    }
}

@HtmlDsl
inline fun HtmlWriter.body(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("body", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("body")
    }
}

@HtmlDsl
inline fun HtmlContext.body(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeNormalElementStart("body", id, classes, style)
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("body")
}

@HtmlDsl
inline fun HtmlContext.body(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeNormalElementStart("body", id, classes, style, attrs)
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("body")
}

@HtmlDsl
inline fun HtmlContext.body(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeNormalElementStart("body", id, classes, style, attrs)
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("body")
}
