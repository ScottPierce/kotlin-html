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
inline fun HtmlWriter.button(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("button")
    this.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun HtmlWriter.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("button")
    this.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun HtmlWriter.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    this.writeTag("button")
    this.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
    this.writeAttributes(attrs)
    this.write('>')
    this.indent()
    BodyContext(this).apply(func)
    this.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("button")
    writer.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("button")
    writer.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("button")
}

@HtmlDsl
inline fun BodyContext.button(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("button")
    writer.writeStandardAttributes(id, classes, style)
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("button")
}
