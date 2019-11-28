package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.Page
import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.backgroundColor
import dev.scottpierce.html.writer.style.styleSheet

class StyleSheetBuilder {
    private var _styles: MutableMap<String, StyleBuilderLambda>? = null
    private var _mediaQueries: MutableMap<String, StyleSheetBuilder>? = null

    private val styles: MutableMap<String, StyleBuilderLambda>
        get() = _styles ?: LinkedHashMap<String, StyleBuilderLambda>().apply { _styles = this }
    private val mediaQueries: MutableMap<String, StyleSheetBuilder>
        get() = _mediaQueries ?: LinkedHashMap<String, StyleSheetBuilder>().apply { _mediaQueries = this }

    @HtmlDsl
    fun style(selector: String, func: StyleBuilderLambda) {
        styles[selector] = func
    }

    fun media(selector: String): StyleSheetBuilder = mediaQueries.getOrPut(selector) { StyleSheetBuilder() }
}

typealias StyleBuilderLambda = StyleSheetBuilderContext.() -> Unit

@HtmlDsl
class StyleSheetBuilderContext(
    override val page: Page,
    private val styleSheetBuilder: StyleSheetBuilder
) : BaseStyleContext {
    fun media(selector: String): StyleSheetBuilder = styleSheetBuilder.media(selector)
}

fun test() {
    StringBuilderHtmlWriter().html {
        styleSheet {
            "blah" {

            }
        }
        style("") {
            backgroundColor(1, 1, 1)

            media("width < 100").style("") {
                backgroundColor(1, 1, 1)
            }
        }
    }
}
