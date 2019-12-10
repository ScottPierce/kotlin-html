// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("meta")
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        if (charset != null) this.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) this.write(" http-equiv=\"").write(httpEquiv).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("meta")
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        if (charset != null) this.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) this.write(" http-equiv=\"").write(httpEquiv).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("meta")
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        if (charset != null) this.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) this.write(" http-equiv=\"").write(httpEquiv).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HeadContext.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    htmlWriter.writeTag("meta")
    if (name != null) htmlWriter.write(" name=\"").write(name).write('"')
    if (content != null) htmlWriter.write(" content=\"").write(content).write('"')
    if (charset != null) htmlWriter.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) htmlWriter.write(" http-equiv=\"").write(httpEquiv).write('"')
    htmlWriter.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    htmlWriter.writeTag("meta")
    if (name != null) htmlWriter.write(" name=\"").write(name).write('"')
    if (content != null) htmlWriter.write(" content=\"").write(content).write('"')
    if (charset != null) htmlWriter.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) htmlWriter.write(" http-equiv=\"").write(httpEquiv).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    htmlWriter.writeTag("meta")
    if (name != null) htmlWriter.write(" name=\"").write(name).write('"')
    if (content != null) htmlWriter.write(" content=\"").write(content).write('"')
    if (charset != null) htmlWriter.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) htmlWriter.write(" http-equiv=\"").write(httpEquiv).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
}
