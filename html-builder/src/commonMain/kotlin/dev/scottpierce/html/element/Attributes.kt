@file:Suppress("unused")

package dev.scottpierce.html.element

import dev.scottpierce.html.ArrayEntry

typealias Attributes = Map<String, String?>
typealias MutableAttributes = MutableMap<String, String?>

object AttributeConstants {
    const val ID = "id"
    const val CLASSES = "classes"
    const val STYLE = "style"
}

var MutableAttributes.id: String?
    get() = this[AttributeConstants.ID]
    set(value) {
        if (value == null) {
            this.remove(AttributeConstants.ID)
        } else {
            this[AttributeConstants.ID] = value
        }
    }

var MutableAttributes.classes: String
    get() = this[AttributeConstants.CLASSES] ?: ""
    set(value) { this[AttributeConstants.ID] = value }

var MutableAttributes.style: String?
    get() = this[AttributeConstants.STYLE] ?: ""
    set(value) {
        if (value == null) {
            this.remove(AttributeConstants.STYLE)
        } else {
            this[AttributeConstants.STYLE] = value
        }
    }

typealias Attribute = MutableMap.MutableEntry<String, String?>

fun String.byNoValue(): Attribute = ArrayEntry(this, null)

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
