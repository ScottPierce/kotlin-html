// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.VideoContext
import dev.scottpierce.html.writer.pageWriterScope
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.video(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("video")
        writeStandardAttributes(id, classes, style)
        if (muted) page.write(" muted")
        if (playsinline) page.write(" playsinline")
        if (autoplay) page.write(" autoplay")
        if (loop) page.write(" loop")
        if (preload != null) page.write(" preload=\"").write(preload).write('"')
        if (poster != null) page.write(" poster=\"").write(poster).write('"')
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("video")
    }
}

@HtmlDsl
inline fun HtmlWriter.video(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("video")
        writeStandardAttributes(id, classes, style)
        if (muted) page.write(" muted")
        if (playsinline) page.write(" playsinline")
        if (autoplay) page.write(" autoplay")
        if (loop) page.write(" loop")
        if (preload != null) page.write(" preload=\"").write(preload).write('"')
        if (poster != null) page.write(" poster=\"").write(poster).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("video")
    }
}

@HtmlDsl
inline fun HtmlWriter.video(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    pageWriterScope(this) {
        writeTag("video")
        writeStandardAttributes(id, classes, style)
        if (muted) page.write(" muted")
        if (playsinline) page.write(" playsinline")
        if (autoplay) page.write(" autoplay")
        if (loop) page.write(" loop")
        if (preload != null) page.write(" preload=\"").write(preload).write('"')
        if (poster != null) page.write(" poster=\"").write(poster).write('"')
        page.writeAttributes(attrs)
        page.write('>')
        page.indent()
        func()
        writeNormalElementEnd("video")
    }
}

@HtmlDsl
inline fun BodyContext.video(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writeTag("video")
    writeStandardAttributes(id, classes, style)
    if (muted) page.write(" muted")
    if (playsinline) page.write(" playsinline")
    if (autoplay) page.write(" autoplay")
    if (loop) page.write(" loop")
    if (preload != null) page.write(" preload=\"").write(preload).write('"')
    if (poster != null) page.write(" poster=\"").write(poster).write('"')
    page.write('>')
    page.indent()
    (this as VideoContext).apply(func)
    writeNormalElementEnd("video")
}

@HtmlDsl
inline fun BodyContext.video(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writeTag("video")
    writeStandardAttributes(id, classes, style)
    if (muted) page.write(" muted")
    if (playsinline) page.write(" playsinline")
    if (autoplay) page.write(" autoplay")
    if (loop) page.write(" loop")
    if (preload != null) page.write(" preload=\"").write(preload).write('"')
    if (poster != null) page.write(" poster=\"").write(poster).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as VideoContext).apply(func)
    writeNormalElementEnd("video")
}

@HtmlDsl
inline fun BodyContext.video(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writeTag("video")
    writeStandardAttributes(id, classes, style)
    if (muted) page.write(" muted")
    if (playsinline) page.write(" playsinline")
    if (autoplay) page.write(" autoplay")
    if (loop) page.write(" loop")
    if (preload != null) page.write(" preload=\"").write(preload).write('"')
    if (poster != null) page.write(" poster=\"").write(poster).write('"')
    page.writeAttributes(attrs)
    page.write('>')
    page.indent()
    (this as VideoContext).apply(func)
    writeNormalElementEnd("video")
}
