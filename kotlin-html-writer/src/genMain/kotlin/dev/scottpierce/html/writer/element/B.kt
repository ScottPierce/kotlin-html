// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.b(func: BodyContext.() -> Unit = {}) {
    this.writeTag("b")
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun HtmlWriter.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    this.writeTag("b")
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun HtmlWriter.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    this.writeTag("b")
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}
