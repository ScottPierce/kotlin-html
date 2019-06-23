package dev.scottpierce.html

import dev.scottpierce.html.element.by

class ArrayMap private constructor(
    private val entryList: MutableList<MutableMap.MutableEntry<String, String?>>
) : MutableMap<String, String?>, Iterable<MutableMap.MutableEntry<String, String?>> {
    constructor() : this(ArrayList(6))
    constructor(initialCapacity: Int) : this(ArrayList(initialCapacity))

    override val size: Int
        get() = entryList.size

    override val entries: MutableSet<MutableMap.MutableEntry<String, String?>>
        get() = ArraySet(this)

    override val keys: MutableSet<String>
        get() {
            val set = HashSet<String>(entryList.size)
            for (entry in entryList) {
                set += entry.key
            }
            return set
        }

    override val values: MutableCollection<String?>
        get() {
            val list = ArrayList<String?>(entryList.size)
            for (entry in entryList) {
                list += entry.value
            }
            return list
        }

    override fun isEmpty(): Boolean = entryList.isEmpty()

    override fun containsKey(key: String): Boolean {
        for (entry in entryList) {
            if (entry.key == key) {
                return true
            }
        }

        return false
    }

    override fun containsValue(value: String?): Boolean {
        for (entry in entryList) {
            if (entry.value == value) {
                return true
            }
        }

        return false
    }

    override fun get(key: String): String? {
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

    override fun put(key: String, value: String?): String? {
        for (attribute in entryList) {
            if (attribute.key == key) {
                return attribute.setValue(value)
            }
        }

        entryList += key by value
        return null
    }

    override fun putAll(from: Map<out String, String?>) {
        for (entry in from) {
            put(entry.key, entry.value)
        }
    }

    override fun remove(key: String): String? {
        for (i in entryList.indices) {
            val attribute = entryList[i]
            if (attribute.key == key) {
                entryList.removeAt(i)
                return attribute.value
            }
        }

        return null
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<String, String?>> = entryList.listIterator()

    fun add(element: MutableMap.MutableEntry<String, String?>): Boolean {
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
}

private class ArraySet(private val entries: ArrayMap) : MutableSet<MutableMap.MutableEntry<String, String?>> {
    override fun add(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return entries.add(element)
    }

    override fun addAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        var result = false
        for (element in elements) {
            result = add(element) || result
        }
        return result
    }

    override fun clear() {
        entries.clear()
    }

    override fun iterator(): MutableIterator<MutableMap.MutableEntry<String, String?>> = entries.iterator()

    override fun remove(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return entries.remove(element.key) != null
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
        get() = entries.size

    override fun contains(element: MutableMap.MutableEntry<String, String?>): Boolean {
        return !entries.containsKey(element.key) || entries[element.key] != element.value
    }

    override fun containsAll(elements: Collection<MutableMap.MutableEntry<String, String?>>): Boolean {
        for (element in elements) {
            if (!contains(element)) {
                return false
            }
        }
        return true
    }

    override fun isEmpty(): Boolean = entries.isEmpty()
}
