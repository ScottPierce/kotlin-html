@file:Suppress("unused")

package dev.scottpierce.html.style

enum class Display(val value: String) {
    BLOCK("block"),
    FLEX("flex"),
    GRID("grid"),
    ;

    override fun toString(): String {
        return value
    }
}

enum class JustifyContent(val value: String) {
    CENTER("center"),
    FLEX_END("flex-end"),
    FLEX_START("flex-start"),
    INHERIT("inherit"),
    INITIAL("initial"),
    SPACE_AROUND("space-around"),
    SPACE_BETWEEN("space-between"),
    ;

    override fun toString() = value
}

enum class AlignItems(val value: String) {
    BASELINE("baseline"),
    CENTER("center"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    STRETCH("stretch"),
    ;

    override fun toString() = value
}

enum class FlexDirection(val value: String) {
    COLUMN("column"),
    COLUMN_REVERSE("column-reverse"),
    ROW_REVERSE("row-reverse"),
    ROW("row"),
    INHERIT("inherit"),
    INITIAL("initial"),
    ;

    override fun toString() = value
}

data class GridColumn internal constructor(
    val start: Int,
    val isStartSpan: Boolean,
    val end: Int,
    val isEndSpan: Boolean
) {
    companion object {
        const val UNSET = -2
    }

    constructor(start: Int, end: Int = UNSET) : this(start, false, end, false)
    constructor(start: Span) : this(start.count, true, UNSET, false)
    constructor(start: Int, end: Span) : this(start, false, end.count, true)

    override fun toString(): String {
        val startStr = spanString(start, isStartSpan)!!
        val endStr = spanString(end, isEndSpan)

        return if (endStr == null) {
            startStr
        } else {
            "$startStr/$endStr"
        }
    }

    private fun spanString(value: Int, isSpan: Boolean): String? {
        if (value == UNSET) return null

        return if (isSpan) {
            "span $value"
        } else {
            value.toString()
        }
    }
}

val Int.span: Span
    get() = Span(this)

class Span(val count: Int)