// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.ScriptContext
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.script(
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("script")
        if (async) page.write(" async")
        if (defer) page.write(" defer")
        if (src != null) page.write(" src=\"").write(src).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun HtmlWriter.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("script")
        if (async) page.write(" async")
        if (defer) page.write(" defer")
        if (src != null) page.write(" src=\"").write(src).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun HtmlWriter.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("script")
        if (async) page.write(" async")
        if (defer) page.write(" defer")
        if (src != null) page.write(" src=\"").write(src).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writeTag("script")
    if (async) page.write(" async")
    if (defer) page.write(" defer")
    if (src != null) page.write(" src=\"").write(src).write('"')
    page.write('>')
    page.indent()
    (this as ScriptContext).apply(func)
    writeNormalElementEnd("script")
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writeTag("script")
    if (async) page.write(" async")
    if (defer) page.write(" defer")
    if (src != null) page.write(" src=\"").write(src).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as ScriptContext).apply(func)
    writeNormalElementEnd("script")
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writeTag("script")
    if (async) page.write(" async")
    if (defer) page.write(" defer")
    if (src != null) page.write(" src=\"").write(src).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as ScriptContext).apply(func)
    writeNormalElementEnd("script")
}
