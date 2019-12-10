// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import dev.scottpierce.html.writer.style.InlineStyleLambda
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.video(
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
        this.writeTag("video")
        this.writeStandardAttributes(id, classes, style)
        if (muted) this.write(" muted")
        if (playsinline) this.write(" playsinline")
        if (autoplay) this.write(" autoplay")
        if (loop) this.write(" loop")
        if (preload != null) this.write(" preload=\"").write(preload).write('"')
        if (poster != null) this.write(" poster=\"").write(poster).write('"')
        this.write('>')
        this.indent()
        VideoContext(this).apply(func)
        this.writeNormalElementEnd("video")
    }
}

@HtmlDsl
inline fun HtmlOutput.video(
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
        this.writeTag("video")
        this.writeStandardAttributes(id, classes, style)
        if (muted) this.write(" muted")
        if (playsinline) this.write(" playsinline")
        if (autoplay) this.write(" autoplay")
        if (loop) this.write(" loop")
        if (preload != null) this.write(" preload=\"").write(preload).write('"')
        if (poster != null) this.write(" poster=\"").write(poster).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        VideoContext(this).apply(func)
        this.writeNormalElementEnd("video")
    }
}

@HtmlDsl
inline fun HtmlOutput.video(
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
        this.writeTag("video")
        this.writeStandardAttributes(id, classes, style)
        if (muted) this.write(" muted")
        if (playsinline) this.write(" playsinline")
        if (autoplay) this.write(" autoplay")
        if (loop) this.write(" loop")
        if (preload != null) this.write(" preload=\"").write(preload).write('"')
        if (poster != null) this.write(" poster=\"").write(poster).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        VideoContext(this).apply(func)
        this.writeNormalElementEnd("video")
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
    htmlWriter.writeTag("video")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (muted) htmlWriter.write(" muted")
    if (playsinline) htmlWriter.write(" playsinline")
    if (autoplay) htmlWriter.write(" autoplay")
    if (loop) htmlWriter.write(" loop")
    if (preload != null) htmlWriter.write(" preload=\"").write(preload).write('"')
    if (poster != null) htmlWriter.write(" poster=\"").write(poster).write('"')
    htmlWriter.write('>')
    htmlWriter.indent()
    VideoContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("video")
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
    htmlWriter.writeTag("video")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (muted) htmlWriter.write(" muted")
    if (playsinline) htmlWriter.write(" playsinline")
    if (autoplay) htmlWriter.write(" autoplay")
    if (loop) htmlWriter.write(" loop")
    if (preload != null) htmlWriter.write(" preload=\"").write(preload).write('"')
    if (poster != null) htmlWriter.write(" poster=\"").write(poster).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    VideoContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("video")
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
    htmlWriter.writeTag("video")
    htmlWriter.writeStandardAttributes(id, classes, style)
    if (muted) htmlWriter.write(" muted")
    if (playsinline) htmlWriter.write(" playsinline")
    if (autoplay) htmlWriter.write(" autoplay")
    if (loop) htmlWriter.write(" loop")
    if (preload != null) htmlWriter.write(" preload=\"").write(preload).write('"')
    if (poster != null) htmlWriter.write(" poster=\"").write(poster).write('"')
    htmlWriter.writeAttributes(attrs)
    htmlWriter.write('>')
    htmlWriter.indent()
    VideoContext(htmlWriter).apply(func)
    htmlWriter.writeNormalElementEnd("video")
}
