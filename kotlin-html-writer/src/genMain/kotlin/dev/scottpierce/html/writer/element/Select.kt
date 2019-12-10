// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.select(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("select", id, classes, style)
        SelectContext(this).apply(func)
        this.writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun HtmlOutput.select(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("select", id, classes, style, attrs)
        SelectContext(this).apply(func)
        this.writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun HtmlOutput.select(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("select", id, classes, style, attrs)
        SelectContext(this).apply(func)
        this.writeNormalElementEnd("select")
    }
}

@HtmlDsl
inline fun BodyContext.select(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("select", id, classes, style)
    SelectContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("select")
}

@HtmlDsl
inline fun BodyContext.select(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("select", id, classes, style, attrs)
    SelectContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("select")
}

@HtmlDsl
inline fun BodyContext.select(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: SelectContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("select", id, classes, style, attrs)
    SelectContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("select")
}
