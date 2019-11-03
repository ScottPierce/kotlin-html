package dev.scottpierce.html.style

import dev.scottpierce.html.element.HtmlDsl

@HtmlDsl
interface InlineStyle {
    val properties: Map<CssProperty, Any?>
}

@HtmlDsl
interface MutableInlineStyle : InlineStyle {
    override val properties: MutableMap<CssProperty, Any?>
}

@HtmlDsl
class LinkedHashMapInlineStyle(
    override val properties: MutableMap<CssProperty, Any?> = LinkedHashMap()
) : MutableInlineStyle

fun mutableInlineStyle(): MutableInlineStyle = LinkedHashMapInlineStyle()

inline fun inlineStyle(func: MutableInlineStyle.() -> Unit): InlineStyle = mutableInlineStyle().apply(func)

operator fun Style.get(property: String): Any? = properties[CssProperty(property)]
