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
inline fun HtmlWriter.input(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("input")
        writeStandardAttributes(id, classes, style)
        if (type != null) page.write(" type=\"").write(type).write('"')
        if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) page.write(" value=\"").write(value).write('"')
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun HtmlWriter.input(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("input")
        writeStandardAttributes(id, classes, style)
        if (type != null) page.write(" type=\"").write(type).write('"')
        if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) page.write(" value=\"").write(value).write('"')
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun HtmlWriter.input(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("input")
        writeStandardAttributes(id, classes, style)
        if (type != null) page.write(" type=\"").write(type).write('"')
        if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) page.write(" value=\"").write(value).write('"')
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun BodyContext.input(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("input")
    writeStandardAttributes(id, classes, style)
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) page.write(" value=\"").write(value).write('"')
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("input")
}

@HtmlDsl
inline fun BodyContext.input(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("input")
    writeStandardAttributes(id, classes, style)
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) page.write(" value=\"").write(value).write('"')
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("input")
}

@HtmlDsl
inline fun BodyContext.input(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writeTag("input")
    writeStandardAttributes(id, classes, style)
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (maxLength != null) page.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) page.write(" value=\"").write(value).write('"')
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (placeholder != null) page.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) page.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) page.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("input")
}
