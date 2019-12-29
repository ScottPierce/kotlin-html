package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.style.style

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val writer: HtmlWriter
}

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
inline class ScriptContext(override val writer: HtmlWriter) : BaseHtmlContext, HasText

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
    operator fun CharSequence.unaryPlus() {
        writer.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}

@HtmlDsl
inline class StyleSheetContext(override val writer: HtmlWriter) : HtmlWriterContext {
    inline operator fun String.invoke(func: StyleLambda) = style(this, func)
}

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
inline class InlineStyleContext(override val writer: HtmlWriter) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val writer: HtmlWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit
