package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val htmlWriter: HtmlWriter
}

@HtmlDsl
inline class FileContext(override val htmlWriter: HtmlWriter) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
inline class HtmlContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class HeadContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class ScriptContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class BodyContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext, HasText

@HtmlDsl
inline class SelectContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class UlContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
inline class VideoContext(override val htmlWriter: HtmlWriter) : BaseHtmlContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun String.unaryPlus() {
        htmlWriter.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}
