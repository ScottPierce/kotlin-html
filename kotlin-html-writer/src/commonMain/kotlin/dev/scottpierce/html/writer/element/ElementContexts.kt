package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val writer: HtmlWriter
}

@HtmlDsl
inline class FileContext(override val writer: HtmlWriter) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
inline class HtmlContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class HeadContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class ScriptContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class BodyContext(override val writer: HtmlWriter) : BaseHtmlContext, HasText

@HtmlDsl
inline class SelectContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class UlContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class VideoContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun String.unaryPlus() {
        writer.newLine()
        writer.write(this)
    }
}
