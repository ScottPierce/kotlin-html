package dev.scottpierce.html.style

import dev.scottpierce.html.element.HtmlDsl

@HtmlDsl
interface StyleSheet {
    val styles: List<Pair<String, StyleSheetElement>>
}

@HtmlDsl
class StyleSheetBuilder : StyleSheet {
    override val styles: MutableList<Pair<String, StyleSheetElement>> = mutableListOf()

    @HtmlDsl
    inline fun style(selector: String, func: StyleBuilder.() -> Unit) {
        styles += selector to StyleBuilder().apply(func)
    }

    @HtmlDsl
    fun style(selector: String, style: Style) {
        styles += selector to style
    }

    @HtmlDsl
    fun media(selector: String, func: StyleSheetBuilder.() -> Unit) {
        val styleSheet = styleSheet(func)
        styles += selector to MediaQuery(styleSheet)
    }
}

inline fun styleSheet(func: StyleSheetBuilder.() -> Unit = {}): StyleSheet = StyleSheetBuilder().apply(func)

@HtmlDsl
class MediaQuery(val styleSheet: StyleSheet) : StyleSheetElement()

inline class StyleSelector(val value: String)
inline class MediaQuerySelector(val value: String)
inline class CssProperty(val value: String)
