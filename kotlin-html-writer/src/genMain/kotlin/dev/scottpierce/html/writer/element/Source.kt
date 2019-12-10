// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.source(src: String? = null, type: String? = null) {
    pageWriterScope(this) {
        this.writeTag("source")
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.source(
    vararg attrs: Pair<String, String?>,
    src: String? = null,
    type: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("source")
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.source(
    attrs: List<Pair<String, String?>>,
    src: String? = null,
    type: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("source")
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun VideoContext.source(src: String? = null, type: String? = null) {
    htmlWriter.writeTag("source")
    if (src != null) htmlWriter.write(" src=\"").write(src).write('"')
    if (type != null) htmlWriter.write(" type=\"").write(type).write('"')
    htmlWriter.write('>')
}

@HtmlDsl
fun VideoContext.source(
    vararg attrs: Pair<String, String?>,
    src: String? = null,
    type: String? = null
) {
    htmlWriter.writeTag("source")
    if (src != null) htmlWriter.write(" src=\"").write(src).write('"')
    if (type != null) htmlWriter.write(" type=\"").write(type).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
}

@HtmlDsl
fun VideoContext.source(
    attrs: List<Pair<String, String?>>,
    src: String? = null,
    type: String? = null
) {
    htmlWriter.writeTag("source")
    if (src != null) htmlWriter.write(" src=\"").write(src).write('"')
    if (type != null) htmlWriter.write(" type=\"").write(type).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
}
