// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.TableRowContext
import kotlin.Int
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun TableRowContext.td(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    td(id = id, classes = classes, style = null, colspan = colspan, rowspan = rowspan, headers =
            headers, func = func)
}

@HtmlDsl
inline fun TableRowContext.td(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    td(attrs = *attrs, id = id, classes = classes, style = null, colspan = colspan, rowspan =
            rowspan, headers = headers, func = func)
}

@HtmlDsl
inline fun TableRowContext.td(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    td(attrs = attrs, id = id, classes = classes, style = null, colspan = colspan, rowspan =
            rowspan, headers = headers, func = func)
}
