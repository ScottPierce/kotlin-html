// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.InlineStyleLambda
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.li(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("li")
    this.writeStandardAttributes(id, classes, style)
    if (value != null) this.write(" value=\"").write(value).write('"')
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("li")
}

@HtmlDsl
inline fun HtmlWriter.li(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("li")
    this.writeStandardAttributes(id, classes, style)
    if (value != null) this.write(" value=\"").write(value).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("li")
}

@HtmlDsl
inline fun HtmlWriter.li(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("li")
    this.writeStandardAttributes(id, classes, style)
    if (value != null) this.write(" value=\"").write(value).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("li")
}

@HtmlDsl
inline fun UlContext.li(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("li")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("li")
}

@HtmlDsl
inline fun UlContext.li(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("li")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("li")
}

@HtmlDsl
inline fun UlContext.li(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("li")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("li")
}
