// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.TableRowContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.td(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("td", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun HtmlOutput.td(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("td", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun HtmlOutput.td(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("td", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun TableRowContext.td(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("td", id, classes, style)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}

@HtmlDsl
inline fun TableRowContext.td(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("td", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}

@HtmlDsl
inline fun TableRowContext.td(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("td", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}
