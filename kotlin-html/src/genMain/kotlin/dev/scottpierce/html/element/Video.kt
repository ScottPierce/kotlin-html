// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.Style
import dev.scottpierce.html.write.HtmlWriter
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlWriter.video(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
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

@HtmlDsl
inline fun HtmlWriter.video(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
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

@HtmlDsl
inline fun HtmlWriter.video(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
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

@HtmlDsl
inline fun BodyContext.video(
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writer.writeTag("video")
    writer.writeStandardAttributes(id, classes, style)
    if (muted) writer.write(" muted")
    if (playsinline) writer.write(" playsinline")
    if (autoplay) writer.write(" autoplay")
    if (loop) writer.write(" loop")
    if (preload != null) writer.write(" preload=\"").write(preload).write('"')
    if (poster != null) writer.write(" poster=\"").write(poster).write('"')
    writer.write('>')
    writer.indent()
    VideoContext(writer).apply(func)
    writer.writeNormalElementEnd("video")
}

@HtmlDsl
inline fun BodyContext.video(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writer.writeTag("video")
    writer.writeStandardAttributes(id, classes, style)
    if (muted) writer.write(" muted")
    if (playsinline) writer.write(" playsinline")
    if (autoplay) writer.write(" autoplay")
    if (loop) writer.write(" loop")
    if (preload != null) writer.write(" preload=\"").write(preload).write('"')
    if (poster != null) writer.write(" poster=\"").write(poster).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    VideoContext(writer).apply(func)
    writer.writeNormalElementEnd("video")
}

@HtmlDsl
inline fun BodyContext.video(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: Style? = null,
    muted: Boolean = false,
    playsinline: Boolean = false,
    autoplay: Boolean = false,
    loop: Boolean = false,
    preload: String? = null,
    poster: String? = null,
    func: VideoContext.() -> Unit = {}
) {
    writer.writeTag("video")
    writer.writeStandardAttributes(id, classes, style)
    if (muted) writer.write(" muted")
    if (playsinline) writer.write(" playsinline")
    if (autoplay) writer.write(" autoplay")
    if (loop) writer.write(" loop")
    if (preload != null) writer.write(" preload=\"").write(preload).write('"')
    if (poster != null) writer.write(" poster=\"").write(poster).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    VideoContext(writer).apply(func)
    writer.writeNormalElementEnd("video")
}
