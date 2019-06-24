@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.style

inline fun style(block: StyleBuilder.() -> Unit): Style {
    val builder = StyleBuilder()
    builder.block()
    return builder.build()
}

inline class StyleBuilder(override val properties: MutableMap<String, Any?> = mutableMapOf()) : Style {
    operator fun set(property: String, value: Any?) {
        properties[property] = value
    }

    override operator fun plus(style: Style): StyleBuilder {
        val properties = LinkedHashMap(properties).apply {
            putAll(style.properties)
        }
        return StyleBuilder(properties)
    }

    fun build(): Style = StyleImpl(properties)

    override fun toString() = toStyleString()
}

interface Style {
    val properties: Map<String, Any?>

    operator fun get(property: String): Any? = properties[property]

    operator fun plus(style: Style): Style {
        return StyleImpl(properties + style.properties)
    }

    fun toStyleString(): String {
        val sb = StringBuilder()

        for ((property, value) in properties) {
            if (value != null) {
                sb.append(property)
                    .append(":")
                    .append(value.toString())
                    .append(";")
            }
        }

        return sb.toString()
    }
}

internal class StyleImpl(override val properties: Map<String, Any?>) : Style {
    override fun toString() = toStyleString()
}
