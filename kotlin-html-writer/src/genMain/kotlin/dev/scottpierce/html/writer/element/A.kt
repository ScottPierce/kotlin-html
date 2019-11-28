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
inline fun HtmlWriter.a(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("a")
        writeStandardAttributes(id, classes, style)
        if (href != null) page.write(" href=\"").write(href).write('"')
        if (target != null) page.write(" target=\"").write(target).write('"')
        if (rel != null) page.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun HtmlWriter.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("a")
        writeStandardAttributes(id, classes, style)
        if (href != null) page.write(" href=\"").write(href).write('"')
        if (target != null) page.write(" target=\"").write(target).write('"')
        if (rel != null) page.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun HtmlWriter.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("a")
        writeStandardAttributes(id, classes, style)
        if (href != null) page.write(" href=\"").write(href).write('"')
        if (target != null) page.write(" target=\"").write(target).write('"')
        if (rel != null) page.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun BodyContext.a(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("a")
    writeStandardAttributes(id, classes, style)
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (target != null) page.write(" target=\"").write(target).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("a")
    writeStandardAttributes(id, classes, style)
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (target != null) page.write(" target=\"").write(target).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("a")
    writeStandardAttributes(id, classes, style)
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (target != null) page.write(" target=\"").write(target).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("a")
}
