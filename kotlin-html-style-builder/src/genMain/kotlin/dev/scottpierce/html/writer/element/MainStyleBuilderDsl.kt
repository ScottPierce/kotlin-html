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
inline fun BodyContext.main(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    main(id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun BodyContext.main(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    main(attrs = *attrs, id = id, classes = classes, style = null, func = func)
}

@HtmlDsl
inline fun BodyContext.main(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    func: BodyContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    main(attrs = attrs, id = id, classes = classes, style = null, func = func)
}
