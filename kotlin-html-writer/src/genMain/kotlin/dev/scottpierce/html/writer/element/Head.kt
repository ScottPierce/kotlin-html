// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.pageWriterScope
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
        writeNormalElementStart("head", id, classes, style)
        func()
        writeNormalElementEnd("head")
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
        writeNormalElementStart("head", id, classes, style, attrs)
        func()
        writeNormalElementEnd("head")
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
        writeNormalElementStart("head", id, classes, style, attrs)
        func()
        writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlContext.head(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writeNormalElementStart("head", id, classes, style)
    (this as HeadContext).apply(func)
    writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writeNormalElementStart("head", id, classes, style, attrs)
    (this as HeadContext).apply(func)
    writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writeNormalElementStart("head", id, classes, style, attrs)
    (this as HeadContext).apply(func)
    writeNormalElementEnd("head")
}
