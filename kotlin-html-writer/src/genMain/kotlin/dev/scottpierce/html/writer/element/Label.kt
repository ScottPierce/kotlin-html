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
inline fun HtmlWriter.label(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun HtmlWriter.label(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun HtmlWriter.label(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun BodyContext.label(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("label")
    page.writeStandardAttributes(id, classes, style)
    if (forId != null) page.write(" for=\"").write(forId).write('"')
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("label")
}

@HtmlDsl
inline fun BodyContext.label(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("label")
    page.writeStandardAttributes(id, classes, style)
    if (forId != null) page.write(" for=\"").write(forId).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("label")
}

@HtmlDsl
inline fun BodyContext.label(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("label")
    page.writeStandardAttributes(id, classes, style)
    if (forId != null) page.write(" for=\"").write(forId).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("label")
}
