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
inline fun HtmlOutput.ul(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("ul", id, classes, style)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun HtmlOutput.ul(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("ul", id, classes, style, attrs)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun HtmlOutput.ul(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeNormalElementStart("ul", id, classes, style, attrs)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun BodyContext.ul(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("ul", id, classes, style)
    UlContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("ul")
}

@HtmlDsl
inline fun BodyContext.ul(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("ul", id, classes, style, attrs)
    UlContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("ul")
}

@HtmlDsl
inline fun BodyContext.ul(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    htmlWriter.writeNormalElementStart("ul", id, classes, style, attrs)
    UlContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("ul")
}
