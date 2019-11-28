// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlWriter.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        writeTag("meta")
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (content != null) page.write(" content=\"").write(content).write('"')
        if (charset != null) page.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
        page.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        writeTag("meta")
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (content != null) page.write(" content=\"").write(content).write('"')
        if (charset != null) page.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
        page.writeAttributes(attrs)
        page.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    pageWriterScope(this) {
        writeTag("meta")
        if (name != null) page.write(" name=\"").write(name).write('"')
        if (content != null) page.write(" content=\"").write(content).write('"')
        if (charset != null) page.write(" charset=\"").write(charset).write('"')
        if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
        page.writeAttributes(attrs)
        page.write('>')
    }
}

@HtmlDsl
fun HeadContext.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (content != null) page.write(" content=\"").write(content).write('"')
    if (charset != null) page.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
    page.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (content != null) page.write(" content=\"").write(content).write('"')
    if (charset != null) page.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    if (name != null) page.write(" name=\"").write(name).write('"')
    if (content != null) page.write(" content=\"").write(content).write('"')
    if (charset != null) page.write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) page.write(" http-equiv=\"").write(httpEquiv).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}
