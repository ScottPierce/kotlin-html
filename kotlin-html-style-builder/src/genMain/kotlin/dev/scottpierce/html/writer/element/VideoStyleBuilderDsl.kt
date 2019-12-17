// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.stylebuilder.StyleBuilderLambda
import dev.scottpierce.html.stylebuilder.style
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.VideoContext
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun BodyContext.video(
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    video(id = id, classes = classes, style = null, muted = muted, playsinline = playsinline,
            autoplay = autoplay, loop = loop, preload = preload, poster = poster, func = func)
}

@HtmlDsl
inline fun BodyContext.video(
    vararg attrs: Pair<String, String?>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    video(attrs = *attrs, id = id, classes = classes, style = null, muted = muted, playsinline =
            playsinline, autoplay = autoplay, loop = loop, preload = preload, poster = poster, func
            = func)
}

@HtmlDsl
inline fun BodyContext.video(
    attrs: List<Pair<String, String?>>,
    id: String,
    classes: String? = null,
    noinline styleBuilder: StyleBuilderLambda,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    style("#$id", styleBuilder)
    video(attrs = attrs, id = id, classes = classes, style = null, muted = muted, playsinline =
            playsinline, autoplay = autoplay, loop = loop, preload = preload, poster = poster, func
            = func)
}
