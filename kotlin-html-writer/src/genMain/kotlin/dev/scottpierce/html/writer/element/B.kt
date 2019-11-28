// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.b(func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("b")
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun HtmlWriter.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("b")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun HtmlWriter.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("b")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun BodyContext.b(func: BodyContext.() -> Unit = {}) {
    writeTag("b")
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writeTag("b")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writeTag("b")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("b")
}
