package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.Page
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.HtmlWriterContext

@HtmlDsl
inline class StyleSheetContext(override val page: Page) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
inline class InlineStyleContext(override val page: Page) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val page: Page) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit
