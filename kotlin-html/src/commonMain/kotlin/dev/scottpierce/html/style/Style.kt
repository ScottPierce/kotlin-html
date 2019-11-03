@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

import dev.scottpierce.html.element.HtmlDsl

operator fun Style.plus(style: Style): InlineStyle {
    val newProperties = LinkedHashMap<CssProperty, Any?>(properties.size + style.properties.size)

    for (prop in properties) {
        newProperties[prop.key] = prop.value
    }

    for (prop in style.properties) {
        newProperties[prop.key] = prop.value
    }

    return InlineStyleBuilder(newProperties)
}
