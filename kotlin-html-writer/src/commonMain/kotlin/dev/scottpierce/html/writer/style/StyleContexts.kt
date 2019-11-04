package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.HtmlWriterContext

@HtmlDsl
inline class StyleSheetContext(override val writer: HtmlWriter) : HtmlWriterContext

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
