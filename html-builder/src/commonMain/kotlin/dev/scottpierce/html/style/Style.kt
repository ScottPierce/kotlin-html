@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter

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
        properties.putAll(this.properties)
    }
}

inline fun style(func: StyleBuilder.() -> Unit): Style {
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
