// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.SelectContext
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun SelectContext.option(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    option(id = id, classes = classes, style = null, value = value, func = func)
}

@HtmlDsl
inline fun SelectContext.option(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    option(attrs = *attrs, id = id, classes = classes, style = null, value = value, func = func)
}

@HtmlDsl
inline fun SelectContext.option(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    option(attrs = attrs, id = id, classes = classes, style = null, value = value, func = func)
}
