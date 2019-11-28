// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.h2(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("h2", id, classes, style)
        func()
        writeNormalElementEnd("h2")
    }
}

@HtmlDsl
inline fun HtmlWriter.h2(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("h2", id, classes, style, attrs)
        func()
        writeNormalElementEnd("h2")
    }
}

@HtmlDsl
inline fun HtmlWriter.h2(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeNormalElementStart("h2", id, classes, style, attrs)
        func()
        writeNormalElementEnd("h2")
    }
}

@HtmlDsl
inline fun BodyContext.h2(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeNormalElementStart("h2", id, classes, style)
    func()
    writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun BodyContext.h2(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeNormalElementStart("h2", id, classes, style, attrs)
    func()
    writeNormalElementEnd("h2")
}

@HtmlDsl
inline fun BodyContext.h2(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeNormalElementStart("h2", id, classes, style, attrs)
    func()
    writeNormalElementEnd("h2")
}
