// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.FileContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.pageWriterScope
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
        writeTag("html")
        writeStandardAttributes(null, classes, style)
        if (lang != null) page.write(" lang=\"").write(lang).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("html")
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
        writeTag("html")
        writeStandardAttributes(null, classes, style)
        if (lang != null) page.write(" lang=\"").write(lang).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("html")
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
        writeTag("html")
        writeStandardAttributes(null, classes, style)
        if (lang != null) page.write(" lang=\"").write(lang).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("html")
    }
}

@HtmlDsl
inline fun FileContext.html(
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writeTag("html")
    writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.write('>')
    page.indent()
    (this as HtmlContext).apply(func)
    writeNormalElementEnd("html")
}

@HtmlDsl
inline fun FileContext.html(
    vararg attrs: Pair<String, String?>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writeTag("html")
    writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as HtmlContext).apply(func)
    writeNormalElementEnd("html")
}

@HtmlDsl
inline fun FileContext.html(
    attrs: List<Pair<String, String?>>,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writeTag("html")
    writeStandardAttributes(null, classes, style)
    if (lang != null) page.write(" lang=\"").write(lang).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as HtmlContext).apply(func)
    writeNormalElementEnd("html")
}
