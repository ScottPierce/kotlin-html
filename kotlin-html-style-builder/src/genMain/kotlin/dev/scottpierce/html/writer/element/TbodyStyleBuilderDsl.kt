// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.TableContext
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun TableContext.tbody(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: TableContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    tbody(id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun TableContext.tbody(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: TableContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    tbody(attrs = *attrs, id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun TableContext.tbody(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: TableContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    tbody(attrs = attrs, id = id, classes = classes, style = null, func = func)
}
