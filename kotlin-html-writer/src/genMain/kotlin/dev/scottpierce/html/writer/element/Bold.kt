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
inline fun HtmlOutput.bold(func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("bold")
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun HtmlOutput.bold(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("bold")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun HtmlOutput.bold(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    pageWriterScope(this) {
        this.writeTag("bold")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("bold")
    }
}

@HtmlDsl
inline fun BodyContext.bold(func: BodyContext.() -> Unit = {}) {
    htmlWriter.writeTag("bold")
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("bold")
}

@HtmlDsl
inline fun BodyContext.bold(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit =
        {}) {
    htmlWriter.writeTag("bold")
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("bold")
}

@HtmlDsl
inline fun BodyContext.bold(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    htmlWriter.writeTag("bold")
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    func()
    htmlWriter.writeNormalElementEnd("bold")
}
