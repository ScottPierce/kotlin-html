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
inline fun HtmlWriter.button(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("button")
        writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("button")
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
        writeTag("button")
        writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("button")
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
        writeTag("button")
        writeStandardAttributes(id, classes, style)
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("button")
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
    writeTag("button")
    writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("button")
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
    writeTag("button")
    writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("button")
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
    writeTag("button")
    writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("button")
}
