@file:Suppress("unused")

package dev.scottpierce.html

typealias Attributes = MutableMap<String, String?>

object AttributeConstants {
    const val ID = "id"
    const val CLASSES = "classes"
    const val STYLE = "style"
}

var Attributes.id: String?
    get() = this[AttributeConstants.ID]
    set(value) {
        if (value == null) {
            this.remove(AttributeConstants.ID)
        } else {
            this[AttributeConstants.ID] = value
        }
    }

var Attributes.classes: String
    get() = this[AttributeConstants.CLASSES] ?: ""
    set(value) { this[AttributeConstants.ID] = value }

var Attributes.style: String?
    get() = this[AttributeConstants.STYLE] ?: ""
    set(value) {
        if (value == null) {
            this.remove(AttributeConstants.STYLE)
        } else {
            this[AttributeConstants.STYLE] = value
        }
    }

data class Attribute(
    override val key: String,
    override var value: String?
) : MutableMap.MutableEntry<String, String?> {
    override fun setValue(newValue: String?): String? {
        val oldValue = value
        value = newValue
        return oldValue
    }
}

infix fun String.by(that: String?): Attribute = Attribute(this, that)

fun String.byNoValue(): Attribute = Attribute(this, null)

fun <K, V> MutableMap<K, V>.putAll(entries: List<MutableMap.MutableEntry<K, V>>) {
    for ((key, value) in entries) {
        put(key, value)
    }
}

fun <K, V> MutableMap<K, V>.putAll(entries: Array<MutableMap.MutableEntry<K, V>>) {
    for ((key, value) in entries) {
        put(key, value)
    }
}
