package dev.scottpierce.html

interface Attributes {
    companion object {
        val EMPTY: Attributes = EmptyAttributes()
        const val ATTR_ID = "id"
        const val ATTR_CLASSES = "classess"
    }

    val size: Int

    operator fun get(key: String): String?
    operator fun get(index: Int): String?
    fun getKey(index: Int): String
}

interface MutableAttributes : Attributes {
    fun put(key: String, value: String)
    fun remove(key: String)
    fun remove(index: Int)
}

private class EmptyAttributes : Attributes {
    override val size: Int = 0
    override fun get(key: String): String? = null
    override fun get(index: Int): String? = null
    override fun getKey(index: Int): String = throw IndexOutOfBoundsException()
}

class ArrayAttributes(startingSize: Int = 4) : MutableAttributes {
    private val keys: MutableList<String> = ArrayList(startingSize)
    private val values: MutableList<String> = ArrayList(startingSize)

    override val size: Int
        get() = keys.size

    override fun put(key: String, value: String) {
        keys.indices
        keys.add(key)
        values.add(value)
    }

    override operator fun get(key: String): String? {
        val valueIndex = keys.indexOf(key)

        return if (valueIndex == -1) {
            null
        } else {
            get(valueIndex)
        }
    }

    override operator fun get(index: Int): String? {
        return values[index]
    }

    override fun getKey(index: Int): String {
        return keys[index]
    }

    override fun remove(key: String) {
        val index = keys.indexOf(key)
        if (index != -1) {
            remove(index)
        }
    }

    override fun remove(index: Int) {
        keys.removeAt(index)
        values.removeAt(index)
    }
}

val Attributes.indices: IntRange
    get() = 0 until size

operator fun MutableAttributes.set(key: String, value: String) {
    put(key, value)
}

val Attributes.id: String?
    get() = this[Attributes.ATTR_ID]

val Attributes.classes: String
    get() = this[Attributes.ATTR_CLASSES] ?: ""
