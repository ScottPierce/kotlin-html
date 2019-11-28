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
inline fun HtmlWriter.bold(func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("bold")
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun HtmlWriter.bold(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("bold")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun HtmlWriter.bold(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("bold")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun BodyContext.bold(func: BodyContext.() -> Unit = {}) {
    writeTag("bold")
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("bold")
}

@HtmlDsl
inline fun BodyContext.bold(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit =
        {}) {
    writeTag("bold")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("bold")
}

@HtmlDsl
inline fun BodyContext.bold(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writeTag("bold")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("bold")
}
