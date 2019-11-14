package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.PageWriter
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.HtmlWriterContext

@HtmlDsl
inline class StyleSheetContext(override val writer: PageWriter) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
inline class InlineStyleContext(override val writer: PageWriter) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val writer: PageWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit
