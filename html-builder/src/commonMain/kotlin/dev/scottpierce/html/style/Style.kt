@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import kotlin.Unit

interface Style : Writable {
    val size: Int

    operator fun get(property: String): Any?
    operator fun iterator(): Iterator<Map.Entry<String, Any?>>

    operator fun plus(style: Style): Style {
        val newProperties = LinkedHashMap<String, Any?>(size + style.size)

        for (prop in this) {
            newProperties[prop.key] = prop.value
        }

        for (prop in style) {
            newProperties[prop.key] = prop.value
        }

        return StyleBuilder(newProperties)
    }

    override fun write(writer: HtmlWriter) {
        writer.writeStyle(this)
    }
}

class StyleBuilder(
    internal val properties: MutableMap<String, Any?> = LinkedHashMap()
) : Style {
    override val size: Int
        get() = properties.size

    override fun get(property: String): Any? = properties[property]

    override fun iterator(): Iterator<Map.Entry<String, Any?>> = properties.iterator()

    operator fun set(property: String, value: Any?) {
        properties[property] = value
    }

    override operator fun plus(style: Style): StyleBuilder {
        val properties = LinkedHashMap(properties).apply {
//            putAll(style.properties)
        }
        return StyleBuilder(properties)
    }

    operator fun Style.unaryPlus() {
    }

    operator fun StyleBuilder.unaryPlus() {
        properties.putAll(this.properties)
    }
}

inline fun style(func: StyleBuilder.() -> Unit): Style {
    return StyleBuilder().apply(func)
}
