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
inline fun HtmlWriter.button(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("button")
        this.writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("button")
    }
}

@HtmlDsl
inline fun HtmlWriter.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("button")
        this.writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("button")
    }
}

@HtmlDsl
inline fun HtmlWriter.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("button")
        this.writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("button")
    }
}

@HtmlDsl
inline fun BodyContext.button(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("button")
    page.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("button")
    page.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    page.writeTag("button")
    page.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    page.writeNormalElementEnd("button")
}
