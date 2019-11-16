// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlWriter.img(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.img(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlWriter.img(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    pageWriterScope(this) {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun BodyContext.img(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    page.writeTag("img")
    page.writeStandardAttributes(id, classes, style)
    if (src != null) page.write(" src=\"").write(src).write('"')
    if (alt != null) page.write(" alt=\"").write(alt).write('"')
    if (width != null) page.write(" width=\"").write(width).write('"')
    if (height != null) page.write(" height=\"").write(height).write('"')
    page.write('>')
}

@HtmlDsl
fun BodyContext.img(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    page.writeTag("img")
    page.writeStandardAttributes(id, classes, style)
    if (src != null) page.write(" src=\"").write(src).write('"')
    if (alt != null) page.write(" alt=\"").write(alt).write('"')
    if (width != null) page.write(" width=\"").write(width).write('"')
    if (height != null) page.write(" height=\"").write(height).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}

@HtmlDsl
fun BodyContext.img(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    page.writeTag("img")
    page.writeStandardAttributes(id, classes, style)
    if (src != null) page.write(" src=\"").write(src).write('"')
    if (alt != null) page.write(" alt=\"").write(alt).write('"')
    if (width != null) page.write(" width=\"").write(width).write('"')
    if (height != null) page.write(" height=\"").write(height).write('"')
    page.writeAttributes(attrs)
    page.write('>')
}
