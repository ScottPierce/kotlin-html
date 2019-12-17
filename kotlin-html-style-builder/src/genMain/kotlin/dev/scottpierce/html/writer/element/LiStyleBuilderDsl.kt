// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.UlContext
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun UlContext.li(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    li(id = id, classes = classes, style = null, value = value, func = func)
}

@HtmlDsl
inline fun UlContext.li(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    li(attrs = *attrs, id = id, classes = classes, style = null, value = value, func = func)
}

@HtmlDsl
inline fun UlContext.li(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    li(attrs = attrs, id = id, classes = classes, style = null, value = value, func = func)
}
