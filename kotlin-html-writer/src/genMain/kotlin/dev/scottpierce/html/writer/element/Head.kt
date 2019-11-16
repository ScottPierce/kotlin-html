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
inline fun HtmlWriter.head(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("head", id, classes, style)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlWriter.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("head", id, classes, style, attrs)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlWriter.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("head", id, classes, style, attrs)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlContext.head(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    page.writeNormalElementStart("head", id, classes, style)
    HeadContext(page).apply(func)
    page.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    page.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(page).apply(func)
    page.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    page.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(page).apply(func)
    page.writeNormalElementEnd("head")
}
