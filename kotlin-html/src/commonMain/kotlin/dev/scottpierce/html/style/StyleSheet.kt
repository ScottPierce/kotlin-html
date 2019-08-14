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

sealed class StyleSheetElement

@HtmlDsl
abstract class Style : StyleSheetElement() {
    abstract val properties: Map<String, Any?>
}

@HtmlDsl
class MediaQuery(val styleSheet: StyleSheet) : StyleSheetElement()
