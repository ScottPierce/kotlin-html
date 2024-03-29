// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun BodyContext.a(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    a(id = id, classes = classes, style = null, href = href, target = target, rel = rel, ariaLabel =
            ariaLabel, func = func)
}

@HtmlDsl
inline fun BodyContext.a(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    a(attrs = attrs, id = id, classes = classes, style = null, href = href, target = target, rel =
            rel, ariaLabel = ariaLabel, func = func)
}

@HtmlDsl
inline fun BodyContext.a(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    a(attrs = attrs, id = id, classes = classes, style = null, href = href, target = target, rel =
            rel, ariaLabel = ariaLabel, func = func)
}
