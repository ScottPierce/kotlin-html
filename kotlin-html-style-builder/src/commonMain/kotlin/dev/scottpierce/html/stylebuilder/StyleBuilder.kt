package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.element.BaseHtmlContext
import dev.scottpierce.html.writer.element.HtmlDsl

@HtmlDsl
fun BaseHtmlContext.style(selector: String, func: StyleBuilderContext.() -> Unit) {
    page.styleSheet.style(selector, func)
}

@HtmlDsl
fun BaseHtmlContext.media(mediaSelector: String): StyleSheetBuilder = page.styleSheet.media(mediaSelector)
