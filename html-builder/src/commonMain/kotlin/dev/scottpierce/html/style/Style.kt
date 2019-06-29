@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import kotlin.Unit

interface Style : Writable {
    val properties: MutableMap<String, Any?>

    override fun write(writer: HtmlWriter) {
        writer.writeStyle(this)
    }
}

class StyleBuilder(
    override val properties: MutableMap<String, Any?> = LinkedHashMap()
) : Style {
    operator fun set(property: String, value: Any?) {
        properties[property] = value
    }

    operator fun Style.unaryPlus() {
        properties.putAll(this.properties)
    }
}

inline fun style(func: StyleBuilder.() -> Unit): Style {
    return StyleBuilder().apply(func)
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
