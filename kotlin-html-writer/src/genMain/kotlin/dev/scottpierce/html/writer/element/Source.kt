// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlWriter.source(src: String? = null, type: String? = null) {
    this.writeTag("source")
    if (src != null) this.write(" src=\"").write(src).write('"')
    if (type != null) this.write(" type=\"").write(type).write('"')
    this.write('>')
}

@HtmlDsl
fun HtmlWriter.source(
    vararg attrs: Pair<String, String?>,
    src: String? = null,
    type: String? = null
) {
    this.writeTag("source")
    if (src != null) this.write(" src=\"").write(src).write('"')
    if (type != null) this.write(" type=\"").write(type).write('"')
    this.writeAttributes(attrs)
    this.write('>')
}

@HtmlDsl
fun HtmlWriter.source(
    attrs: List<Pair<String, String?>>,
    src: String? = null,
    type: String? = null
) {
    this.writeTag("source")
    if (src != null) this.write(" src=\"").write(src).write('"')
    if (type != null) this.write(" type=\"").write(type).write('"')
    this.writeAttributes(attrs)
    this.write('>')
}

@HtmlDsl
fun VideoContext.source(src: String? = null, type: String? = null) {
    writer.writeTag("source")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.write('>')
}

@HtmlDsl
fun VideoContext.source(
    vararg attrs: Pair<String, String?>,
    src: String? = null,
    type: String? = null
) {
    writer.writeTag("source")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun VideoContext.source(
    attrs: List<Pair<String, String?>>,
    src: String? = null,
    type: String? = null
) {
    writer.writeTag("source")
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}
