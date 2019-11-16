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
inline fun HtmlWriter.option(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun HtmlWriter.option(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun HtmlWriter.option(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun SelectContext.option(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("option")
    page.writeStandardAttributes(id, classes, style)
    if (value != null) page.write(" value=\"").write(value).write('"')
    page.write('>')
    page.indent()
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("option")
}

@HtmlDsl
inline fun SelectContext.option(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("option")
    page.writeStandardAttributes(id, classes, style)
    if (value != null) page.write(" value=\"").write(value).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("option")
}

@HtmlDsl
inline fun SelectContext.option(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("option")
    page.writeStandardAttributes(id, classes, style)
    if (value != null) page.write(" value=\"").write(value).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    BodyContext(page).apply(func)
    page.writeNormalElementEnd("option")
}
