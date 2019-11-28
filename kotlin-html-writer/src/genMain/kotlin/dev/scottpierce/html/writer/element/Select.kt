// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.SelectContext
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.select(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("select", id, classes, style)
        func()
        writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun HtmlWriter.select(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("select", id, classes, style, attrs)
        func()
        writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun HtmlWriter.select(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("select", id, classes, style, attrs)
        func()
        writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun BodyContext.select(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    writeNormalElementStart("select", id, classes, style)
    (this as SelectContext).apply(func)
    writeNormalElementEnd("select")
}

@HtmlDsl
inline fun BodyContext.select(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    writeNormalElementStart("select", id, classes, style, attrs)
    (this as SelectContext).apply(func)
    writeNormalElementEnd("select")
}

@HtmlDsl
inline fun BodyContext.select(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    writeNormalElementStart("select", id, classes, style, attrs)
    (this as SelectContext).apply(func)
    writeNormalElementEnd("select")
}
