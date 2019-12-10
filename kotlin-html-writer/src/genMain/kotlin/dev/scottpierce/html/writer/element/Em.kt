// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.em(func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("em")
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlOutput.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("em")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlOutput.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("em")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun BodyContext.em(func: BodyContext.() -> Unit = {}) {
    htmlWriter.writeTag("em")
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    htmlWriter.writeTag("em")
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    htmlWriter.writeTag("em")
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("em")
}
