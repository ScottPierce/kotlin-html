// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
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
    this.writeTag("script")
    if (async) this.write(" async")
    if (defer) this.write(" defer")
    if (src != null) this.write(" src=\"").write(src).write('"')
    this.write('>')
    this.indent()
    ScriptContext(this).apply(func)
    this.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun HtmlWriter.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    this.writeTag("script")
    if (async) this.write(" async")
    if (defer) this.write(" defer")
    if (src != null) this.write(" src=\"").write(src).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    ScriptContext(this).apply(func)
    this.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun HtmlWriter.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    this.writeTag("script")
    if (async) this.write(" async")
    if (defer) this.write(" defer")
    if (src != null) this.write(" src=\"").write(src).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    ScriptContext(this).apply(func)
    this.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun HtmlWriterContext.script(
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun HtmlWriterContext.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun HtmlWriterContext.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    src: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}
