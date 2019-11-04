package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.element.Context
import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
inline class StyleSheetContext(override val writer: HtmlWriter) : Context

@HtmlDsl
interface BaseStyleContext : Context

@HtmlDsl
inline class InlineStyleContext(override val writer: HtmlWriter) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val writer: HtmlWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit
