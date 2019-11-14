package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.PageWriter

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val writer: PageWriter
}

@HtmlDsl
inline class FileContext(override val writer: PageWriter) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
inline class HtmlContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
inline class HeadContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
inline class ScriptContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
inline class BodyContext(override val writer: PageWriter) : BaseHtmlContext, HasText

@HtmlDsl
inline class SelectContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
inline class UlContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
inline class VideoContext(override val writer: PageWriter) : BaseHtmlContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun String.unaryPlus() {
        writer.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}
