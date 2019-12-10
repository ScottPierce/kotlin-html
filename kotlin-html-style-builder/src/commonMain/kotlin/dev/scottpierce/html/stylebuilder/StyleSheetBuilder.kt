package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.style.BaseStyleContext
import dev.scottpierce.html.writer.style.StyleLambda

class StyleSheetBuilder(private val indent: Int) {
    internal val output: HtmlOutput = StringHtmlOutput()
    internal var _mediaQueries: MutableMap<String, StyleSheetBuilder>? = null

    private val mediaQueries: MutableMap<String, StyleSheetBuilder>
        get() = _mediaQueries ?: LinkedHashMap<String, StyleSheetBuilder>(6).apply { _mediaQueries = this }

    @HtmlDsl
    fun media(selector: String): StyleSheetBuilder = mediaQueries.getOrPut(selector) { StyleSheetBuilder(indent + 1) }
}

@HtmlDsl
inline fun style(selector: String, func: StyleLambda) {

}

@HtmlDsl
class StyleBuilderContext(
    override val htmlWriter: HtmlWriter,
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
