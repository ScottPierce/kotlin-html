// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.nav(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("nav", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("nav")
    }
}

@HtmlDsl
fun HtmlOutput.nav(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("nav", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("nav")
    }
}

@HtmlDsl
fun HtmlOutput.nav(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("nav", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("nav")
    }
}

@HtmlDsl
inline fun BodyContext.nav(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style)
    func()
    writer.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun BodyContext.nav(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("nav")
}

@HtmlDsl
inline fun BodyContext.nav(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("nav", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("nav")
}
