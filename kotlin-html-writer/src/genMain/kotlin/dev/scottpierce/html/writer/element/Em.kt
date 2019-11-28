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
inline fun HtmlWriter.em(func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("em")
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlWriter.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("em")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlWriter.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        writeTag("em")
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun BodyContext.em(func: BodyContext.() -> Unit = {}) {
    writeTag("em")
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writeTag("em")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writeTag("em")
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    func()
    writeNormalElementEnd("em")
}
