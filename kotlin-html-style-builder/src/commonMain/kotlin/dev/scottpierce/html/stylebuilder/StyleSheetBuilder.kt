package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.Page
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.style.BaseStyleContext

class StyleSheetBuilder {
    internal var _styles: MutableMap<String, StyleBuilderLambda>? = null
    internal var _mediaQueries: MutableMap<String, StyleSheetBuilder>? = null

    private val styles: MutableMap<String, StyleBuilderLambda>
        get() = _styles ?: LinkedHashMap<String, StyleBuilderLambda>().apply { _styles = this }
    private val mediaQueries: MutableMap<String, StyleSheetBuilder>
        get() = _mediaQueries ?: LinkedHashMap<String, StyleSheetBuilder>().apply { _mediaQueries = this }

    @HtmlDsl
    fun style(selector: String, func: StyleBuilderLambda) {
        val oldValue = styles.put(selector, func)
        check(oldValue == null) {
            "Style '$selector' has already been set. Styles must be declared once in a single location."
        }
    }

    @HtmlDsl
    fun media(selector: String): StyleSheetBuilder = mediaQueries.getOrPut(selector) { StyleSheetBuilder() }
}

@HtmlDsl
class StyleBuilderContext(
    override val page: Page,
    private val selector: String,
    private val styleSheetBuilder: StyleSheetBuilder
) : BaseStyleContext {
    @HtmlDsl
    fun media(selector: String, func: StyleBuilderLambda) {
        val mediaBuilder = styleSheetBuilder.media(selector)
        mediaBuilder.style(this.selector, func)
    }
}

typealias StyleBuilderLambda = StyleBuilderContext.() -> Unit
