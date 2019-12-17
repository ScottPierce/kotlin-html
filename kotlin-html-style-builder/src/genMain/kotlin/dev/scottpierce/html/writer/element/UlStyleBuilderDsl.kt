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
inline fun BodyContext.ul(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: UlContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    ul(id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun BodyContext.ul(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: UlContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    ul(attrs = *attrs, id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun BodyContext.ul(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: UlContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    ul(attrs = attrs, id = id, classes = classes, style = null, func = func)
}
