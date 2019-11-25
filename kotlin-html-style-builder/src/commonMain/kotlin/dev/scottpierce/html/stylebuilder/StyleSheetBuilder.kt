package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.Page
import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.BaseStyleContext
import dev.scottpierce.html.writer.style.backgroundColor

class StyleSheetBuilder {
    private var _styles: MutableMap<String, List<StyleBuilderLambda>>? = null
    private var _mediaQueries: MutableMap<String, StyleSheetBuilder>? = null

    private val styles: MutableMap<String, List<StyleBuilderLambda>>
        get() = _styles ?: LinkedHashMap<String, List<StyleBuilderLambda>>().apply { _styles = this }
    private val mediaQueries: MutableMap<String, StyleSheetBuilder>
        get() = _mediaQueries ?: LinkedHashMap<String, StyleSheetBuilder>().apply { _mediaQueries = this }

    @HtmlDsl
    fun style(selector: String, func: StyleBuilderLambda) {
        styles.getOrPut(selector) { ArrayList(1) }
    }

    @HtmlDsl
    fun media(selector: String): StyleSheetBuilder = mediaQueries.getOrPut(selector) { StyleSheetBuilder() }
}

typealias StyleBuilderLambda = StyleSheetBuilderContext.() -> Unit

@HtmlDsl
class StyleSheetBuilderContext(
    override val page: Page,
    private val styleSheetBuilder: StyleSheetBuilder
) : BaseStyleContext {
    @HtmlDsl
    fun media(selector: String): StyleSheetBuilder = styleSheetBuilder.media(selector)
}

fun test() {
    StringBuilderHtmlWriter().html {
        style("") {
            backgroundColor(1, 1, 1)

            media("width < 100").style("") {
                backgroundColor(1, 1, 1)
            }
        }
    }
}
