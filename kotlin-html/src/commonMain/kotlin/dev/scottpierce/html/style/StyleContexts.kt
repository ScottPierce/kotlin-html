package dev.scottpierce.html.style

import dev.scottpierce.html.element.Context
import dev.scottpierce.html.element.HtmlDsl
import dev.scottpierce.html.write.HtmlWriter

@HtmlDsl
interface BaseStyleContext : Context

@HtmlDsl
inline class InlineStyleContext(override val writer: HtmlWriter) : BaseStyleContext

@HtmlDsl
inline class StyleContext(override val writer: HtmlWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit