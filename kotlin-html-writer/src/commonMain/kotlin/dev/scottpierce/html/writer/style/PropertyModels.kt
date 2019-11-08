@file:Suppress("unused")

package dev.scottpierce.html.writer.style

enum class CssValue(val value: String) {
    INITIAL("initial"),
    INHERIT("inherit");

    override fun toString(): String = value
}

enum class AlignSelf(val value: String) {
    AUTO("auto"),
    BASELINE("baseline"),
    CENTER("center"),
    END("end"),
    FLEX_END("flex-end"),
    FLEX_START("flex-start"),
    INITIAL("initial"),
    INHERIT("inherit"),
    STRETCH("stretch"),
    START("start"),
    ;

    override fun toString() = value
}

enum class JustifyContent(val value: String) {
    CENTER("center"),
    FLEX_END("flex-end"),
    FLEX_START("flex-start"),
    INHERIT("inherit"),
    INITIAL("initial"),
    SPACE_AROUND("space-around"),
    SPACE_BETWEEN("space-between"),
    SPACE_EVENLY("space-evenly"),
    ;

    override fun toString() = value
}


enum class AlignItems(val value: String) {
    BASELINE("baseline"),
    CENTER("center"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    STRETCH("stretch"),
    INHERIT("inherit"),
    INITIAL("initial"),
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

enum class FloatDirection(val value: String) {
    NONE("none"),
    LEFT("left"),
    RIGHT("right"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun toString() = value
}

enum class FlexWrap(val value: String) {
    NO_WRAP("nowrap"),
    WRAP("wrap"),
    WRAP_REVERSE("wrap-reverse"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun toString() = value
}

enum class Position(val value: String) {
    STATIC("static"),
    RELATIVE("relative"),
    FIXED("fixed"),
    ABSOLUTE("absolute"),
    STICKY("sticky"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun toString(): String = value
}

// class TextDecoration(
//    vararg val line: Line,
//    vararg val style: Style,
//    val color: Color? = null
// ) {
//    enum class Line(val value: String) {
//        NONE("none"),
//        UNDERLINE("underline"),
//        OVERLINE("overline"),
//        LINE_THROUGH("line-through"),
//        INITIAL("initial"),
//        INHERIT("inherit"),
//        ;
//
//        override fun toString(): String = value
//    }
//
//    enum class Style(val value: String) {
//        SOLID("solid"),
//        DOUBLE("double"),
//        DOTTED("dotted"),
//        DASHED("dashed"),
//        WAVY("wavy"),
//        INITIAL("initial"),
//        INHERIT("inherit"),
//        ;
//
//        override fun toString(): String = value
//    }
//
//    override fun toString(): String {
//        val sb = StringBuilder()
//
//        sb.append(line)
//
//        if ()
//
//        return sb.toString()
//    }
// }

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
