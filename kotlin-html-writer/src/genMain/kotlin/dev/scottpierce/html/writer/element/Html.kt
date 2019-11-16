// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.html(
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
    }
}

@HtmlDsl
inline fun HtmlWriter.html(
    vararg attrs: Pair<String, String?>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
    }
}

@HtmlDsl
inline fun HtmlWriter.html(
    attrs: List<Pair<String, String?>>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
    }
}

@HtmlDsl
inline fun FileContext.html(
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    page.writeTag("html")
    page.writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.write('>')
    page.indent()
    HtmlContext(page).apply(func)
    page.writeNormalElementEnd("html")
}

@HtmlDsl
inline fun FileContext.html(
    vararg attrs: Pair<String, String?>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    page.writeTag("html")
    page.writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    HtmlContext(page).apply(func)
    page.writeNormalElementEnd("html")
}

@HtmlDsl
inline fun FileContext.html(
    attrs: List<Pair<String, String?>>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    page.writeTag("html")
    page.writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    HtmlContext(page).apply(func)
    page.writeNormalElementEnd("html")
}
