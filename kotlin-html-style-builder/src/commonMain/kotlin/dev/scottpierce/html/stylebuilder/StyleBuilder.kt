package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlDsl

@HtmlDsl
fun BaseHtmlContext.style(selector: String, func: StyleBuilderContext.() -> Unit) {
    writer.styleSheet.style(selector, func)
}

@HtmlDsl
fun BaseHtmlContext.media(mediaSelector: String): StyleSheetBuilder = writer.styleSheet.media(mediaSelector)
