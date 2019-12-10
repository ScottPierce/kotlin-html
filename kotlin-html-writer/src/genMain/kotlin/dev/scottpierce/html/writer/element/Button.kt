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
inline fun HtmlOutput.button(
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
inline fun HtmlOutput.button(
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
inline fun HtmlOutput.button(
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
    htmlWriter.writeTag("button")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) htmlWriter.write(" aria-label=\"").write(ariaLabel).write('"')
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("button")
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
    htmlWriter.writeTag("button")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) htmlWriter.write(" aria-label=\"").write(ariaLabel).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("button")
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
    htmlWriter.writeTag("button")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) htmlWriter.write(" aria-label=\"").write(ariaLabel).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("button")
}
