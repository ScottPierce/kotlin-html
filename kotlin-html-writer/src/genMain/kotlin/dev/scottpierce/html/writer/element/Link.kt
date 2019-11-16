// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlWriter.link(
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.link(
    vararg attrs: Pair<String, String?>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.link(
    attrs: List<Pair<String, String?>>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun BaseHtmlContext.link(
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    page.writeTag("link")
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) page.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) page.write(" media=\"").write(media).write('"')
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (sizes != null) page.write(" sizes=\"").write(sizes).write('"')
    page.write('>')
}

@HtmlDsl
fun BaseHtmlContext.link(
    vararg attrs: Pair<String, String?>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    page.writeTag("link")
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) page.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) page.write(" media=\"").write(media).write('"')
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (sizes != null) page.write(" sizes=\"").write(sizes).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}

@HtmlDsl
fun BaseHtmlContext.link(
    attrs: List<Pair<String, String?>>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    page.writeTag("link")
    if (href != null) page.write(" href=\"").write(href).write('"')
    if (rel != null) page.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) page.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) page.write(" media=\"").write(media).write('"')
    if (type != null) page.write(" type=\"").write(type).write('"')
    if (sizes != null) page.write(" sizes=\"").write(sizes).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}
