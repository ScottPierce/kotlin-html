// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlContext.head(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: HeadContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    head(id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun HtmlContext.head(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: HeadContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    head(attrs = *attrs, id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun HtmlContext.head(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: HeadContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    head(attrs = attrs, id = id, classes = classes, style = null, func = func)
}
