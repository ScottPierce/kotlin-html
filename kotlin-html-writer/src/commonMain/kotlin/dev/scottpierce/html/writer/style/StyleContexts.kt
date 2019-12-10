package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.HtmlWriterContext

@HtmlDsl
inline class StyleSheetContext(val htmlWriter: HtmlWriter) : HtmlWriterContext {
    operator fun String.invoke(func: StyleLambda) = style(this, func)
}

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
inline class InlineStyleContext(override val htmlWriter: HtmlWriter) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val htmlWriter: HtmlWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit
