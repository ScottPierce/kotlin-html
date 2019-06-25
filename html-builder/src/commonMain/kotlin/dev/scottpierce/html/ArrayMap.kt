package dev.scottpierce.html

class ArrayMap<K, V> internal constructor(
    internal val entryList: MutableList<MutableMap.MutableEntry<K, V>>
) : MutableMap<K, V>, Iterable<MutableMap.MutableEntry<K, V>> {
    constructor() : this(ArrayList(6))
    constructor(initialCapacity: Int) : this(ArrayList(initialCapacity))

    override val size: Int
        get() = entryList.size

    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = ArraySet(this)

    override val keys: MutableSet<K>
        get() {
            val set = HashSet<K>(entryList.size)
            for (entry in entryList) {
                set += entry.key
            }
            return set
        }

    override val values: MutableCollection<V>
        get() {
            val list = ArrayList<V>(entryList.size)
            for (entry in entryList) {
                list += entry.value
            }
            return list
        }

    override fun isEmpty(): Boolean = entryList.isEmpty()

    override fun containsKey(key: K): Boolean {
        for (entry in entryList) {
            if (entry.key == key) {
                return true
            }
        }

        return false
    }

    override fun containsValue(value: V): Boolean {
        for (entry in entryList) {
            if (entry.value == value) {
                return true
            }
        }

        return false
    }

    override fun get(key: K): V? {
        for (entry in entryList) {
            if (entry.key == key) {
                return entry.value
            }
        }

        return null
    }

    override fun clear() {
        entryList.clear()
    }

    override fun put(key: K, value: V): V? {
        for (attribute in entryList) {
            if (attribute.key == key) {
                return attribute.setValue(value)
            }
        }

        entryList += key by value
        return null
    }

    override fun putAll(from: Map<out K, V>) {
        for (entry in from) {
            put(entry.key, entry.value)
        }
    }

    override fun remove(key: K): V? {
        for (i in entryList.indices) {
            val attribute = entryList[i]
            if (attribute.key == key) {
                entryList.removeAt(i)
                return attribute.value
            }
        }

        return null
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<K, V>> = entryList.listIterator()

    fun add(element: MutableMap.MutableEntry<K, V>): Boolean {
        for (attribute in entryList) {
            if (attribute.key == element.key) {
                val isChanged = attribute.value != element.value
                attribute.setValue(element.value)
                return isChanged
            }
        }

        entryList.add(element)
        return false
    }

    fun addAll(elements: Collection<MutableMap.MutableEntry<K, V>>) {
        for (element in elements) {
            add(element)
        }
    }
}

data class ArrayEntry<K, V>(
    override val key: K,
    override var value: V
) : MutableMap.MutableEntry<K, V> {
    override fun setValue(newValue: V): V {
        val oldValue = value
        value = newValue
        return oldValue
    }
}

infix fun <K, V> K.by(that: V): ArrayEntry<K, V> = ArrayEntry(this, that)

private class ArraySet<K, V>(private val entries: ArrayMap<K, V>) : MutableSet<MutableMap.MutableEntry<K, V>> {
    override fun add(element: MutableMap.MutableEntry<K, V>): Boolean {
        return entries.add(element)
    }

    override fun addAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        var result = false
        for (element in elements) {
            result = add(element) || result
        }
        return result
    }

    override fun clear() {
        entries.clear()
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<K, V>> = entries.iterator()

    override fun remove(element: MutableMap.MutableEntry<K, V>): Boolean {
        return entries.remove(element.key) != null
    }

    override fun removeAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        var result = false
        for (element in elements) {
            result = remove(element) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        TODO("not implemented")
    }

    override val size: Int
        get() = entries.size

    override fun contains(element: MutableMap.MutableEntry<K, V>): Boolean {
        return !entries.containsKey(element.key) || entries[element.key] != element.value
    }

    override fun containsAll(elements: Collection<MutableMap.MutableEntry<K, V>>): Boolean {
        for (element in elements) {
            if (!contains(element)) {
                return false
            }
        }
        return true
    }

    override fun isEmpty(): Boolean = entries.isEmpty()
}
