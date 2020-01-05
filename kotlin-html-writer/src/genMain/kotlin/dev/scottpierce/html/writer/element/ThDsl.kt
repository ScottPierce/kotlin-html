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
inline fun HtmlOutput.th(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("th", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun HtmlOutput.th(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("th", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun HtmlOutput.th(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("th", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun TableRowContext.th(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("th", id, classes, style)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}

@HtmlDsl
inline fun TableRowContext.th(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("th", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}

@HtmlDsl
inline fun TableRowContext.th(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("th", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}
