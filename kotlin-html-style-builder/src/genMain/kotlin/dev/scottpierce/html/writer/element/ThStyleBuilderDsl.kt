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
inline fun TableRowContext.th(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    th(id = id, classes = classes, style = null, colspan = colspan, rowspan = rowspan, abbr = abbr,
            headers = headers, scope = scope, sorted = sorted, func = func)
}

@HtmlDsl
inline fun TableRowContext.th(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    th(attrs = *attrs, id = id, classes = classes, style = null, colspan = colspan, rowspan =
            rowspan, abbr = abbr, headers = headers, scope = scope, sorted = sorted, func = func)
}

@HtmlDsl
inline fun TableRowContext.th(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    th(attrs = attrs, id = id, classes = classes, style = null, colspan = colspan, rowspan =
            rowspan, abbr = abbr, headers = headers, scope = scope, sorted = sorted, func = func)
}
