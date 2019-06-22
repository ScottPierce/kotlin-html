@file:Suppress("unused")

package dev.scottpierce.html

typealias Attributes = MutableMap<String, String?>

class ArrayAttributes private constructor(
    private val attributes: MutableList<MutableMap.MutableEntry<String, String?>>
) : MutableMap<String, String?>, Iterable<MutableMap.MutableEntry<String, String?>> {
    constructor() : this(ArrayList(6))
    constructor(initialCapacity: Int) : this(ArrayList(initialCapacity))

    override val size: Int
        get() = attributes.size

    override val entries: MutableSet<MutableMap.MutableEntry<String, String?>>
        get() = AttributeSet(this)

    override val keys: MutableSet<String>
        get() {
            val set = HashSet<String>(attributes.size)
            for (pair in attributes) {
                set += pair.key
            }
            return set
        }

    override val values: MutableCollection<String?>
        get() {
            val list = ArrayList<String?>(attributes.size)
            for (pair in attributes) {
                list += pair.value
            }
            return list
        }

    override fun isEmpty(): Boolean = attributes.isEmpty()

    override fun containsKey(key: String): Boolean {
        for (pair in attributes) {
            if (pair.key == key) {
                return true
            }
        }

        return false
    }

    override fun containsValue(value: String?): Boolean {
        for (pair in attributes) {
            if (pair.value == value) {
                return true
            }
        }

        return false
    }

    override fun get(key: String): String? {
        for (pair in attributes) {
            if (pair.key == key) {
                return pair.value
            }
        }

        return null
    }

    override fun clear() {
        attributes.clear()
    }

    override fun put(key: String, value: String?): String? {
        for (attribute in attributes) {
            if (attribute.key == key) {
                return attribute.setValue(value)
            }
        }

        attributes += key by value
        return null
    }

    override fun putAll(from: Map<out String, String?>) {
        for (pair in from) {
            put(pair.key, pair.value)
        }
    }

    override fun remove(key: String): String? {
        for (i in attributes.indices) {
            val attribute = attributes[i]
            if (attribute.key == key) {
                attributes.removeAt(i)
                return attribute.value
            }
        }

        return null
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<String, String?>> = attributes.listIterator()

    fun add(element: MutableMap.MutableEntry<String, String?>): Boolean {
        for (attribute in attributes) {
            if (attribute.key == element.key) {
                val isChanged = attribute.value != element.value
                attribute.setValue(element.value)
                return isChanged
            }
        }

        attributes.add(element)
        return false
    }
}

private class AttributeSet(private val attributes: ArrayAttributes) : MutableSet<MutableMap.MutableEntry<String, String?>> {
    override fun add(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return attributes.add(element)
    }

    override fun addAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        var result = false
        for (element in elements) {
            result = add(element) || result
        }
        return result
    }

    override fun clear() {
        attributes.clear()
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<String, String?>> = attributes.iterator()

    override fun remove(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return attributes.remove(element.key) != null
    }

    override fun removeAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        var result = false
        for (element in elements) {
            result = remove(element) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        TODO("not implemented")
    }

    override val size: Int
        get() = attributes.size

    override fun contains(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return !attributes.containsKey(element.key) || attributes[element.key] != element.value
    }

    override fun containsAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        for (element in elements) {
            if (!contains(element)) {
                return false
            }
        }
        return true
    }

    override fun isEmpty(): Boolean = attributes.isEmpty()
}

object AttributeConstants {
    const val ID = "id"
    const val CLASSES = "classes"
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
    set(value) {
        this[AttributeConstants.ID] = value
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
