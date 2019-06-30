@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

import dev.scottpierce.html.element.HtmlDsl
import dev.scottpierce.html.write.HtmlWriter

@HtmlDsl
interface Style {
    val properties: MutableMap<String, Any?>

    fun write(writer: HtmlWriter, isInline: Boolean) {
        writer.writeStyle(this, isInline)
    }
}

class StyleBuilder(
    override val properties: MutableMap<String, Any?> = LinkedHashMap()
) : Style {
    operator fun Style.unaryPlus() {
        this@StyleBuilder.properties.putAll(properties)
    }
}

inline fun style(func: StyleBuilder.() -> kotlin.Unit): Style {
    val builder = StyleBuilder()
    builder.func()
    return builder
}

operator fun Style.get(property: String): Any? = properties[property]

operator fun Style.plus(style: Style): Style {
    val newProperties = LinkedHashMap<String, Any?>(properties.size + style.properties.size)

    for (prop in properties) {
        newProperties[prop.key] = prop.value
    }

    for (prop in style.properties) {
        newProperties[prop.key] = prop.value
    }

    return StyleBuilder(newProperties)
}
