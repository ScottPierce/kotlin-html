package dev.scottpierce.html.style

import dev.scottpierce.html.element.HtmlDsl

@HtmlDsl
interface StyleSheet {
    val styles: List<Pair<String, Style>>
}

class StyleSheetBuilder : StyleSheet {
    override val styles: MutableList<Pair<String, Style>> = mutableListOf()

    inline fun style(selector: String, func: StyleBuilder.() -> Unit) {
        styles += selector to StyleBuilder().apply(func)
    }
}

inline fun styleSheet(func: StyleSheetBuilder.() -> Unit): StyleSheet = StyleSheetBuilder().apply(func)
