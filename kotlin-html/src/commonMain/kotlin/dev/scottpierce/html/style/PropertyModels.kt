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

data class ListStyle(
    val type: Type,
    val position: Position = DEFAULT_POSITION,
    val image: Image = DEFAULT_IMAGE
) {
    companion object {
        private val DEFAULT_POSITION = Position.OUTSIDE
        private val DEFAULT_IMAGE = Image.None
    }

    override fun toString(): String {
        val sb = StringBuilder()

        sb.append(type)

        val hasPosition: Boolean = position != DEFAULT_POSITION
        val hasImage: Boolean = image !== DEFAULT_IMAGE

        if (hasPosition || hasImage) {
            sb.append(' ')
            sb.append(position)

            if (hasImage) {
                sb.append(' ')
                sb.append(image)
            }
        }

        return sb.toString()
    }

    enum class Type(val value: String) {
        DISC("disc"),
        ARMENIAN("armenian"),
        CIRCLE("circle"),
        CJK_IDEOGRAPHIC("cjk-ideographic"),
        DECIMAL("decimal"),
        DECIMAL_LEADING_ZERO("decimal-leading-zero"),
        GEORGIAN("georgian"),
        HEBREW("hebrew"),
        HIRAGANA("hiragana"),
        HIRAGANA_IROHA("hiragana-iroha"),
        KATAKANA("katakana"),
        KATAKANA_IROHA("katakana-iroha"),
        LOWER_ALPHA("lower-alpha"),
        LOWER_GREEK("lower-greek"),
        LOWER_LATIN("lower-latin"),
        LOWER_ROMAN("lower-roman"),
        NONE("none"),
        SQUARE("square"),
        UPPER_ALPHA("upper-alpha"),
        UPPER_GREEK("upper-greek"),
        UPPER_LATIN("upper-latin"),
        UPPER_ROMAN("upper-roman"),
        INITIAL("initial"),
        INHERIT("inherit"),
        ;

        override fun toString(): String = value
    }

    enum class Position(val value: String) {
        INSIDE("inside"),
        OUTSIDE("outside"),
        INITIAL("initial"),
        INHERIT("inherit"),
        ;

        override fun toString(): String = value
    }

    sealed class Image(val value: String) {
        object None : Image("none")
        class Url(url: String) : Image("url('$url')")
        object Initial : Image("initial")
        object Inherit : Image("inherit")

        override fun toString(): String = value
    }
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

enum class Position(val value: String) {
    STATIC("static"),
    RELATIVE("relative"),
    FIXED("fixed"),
    ABSOLUTE("absolute"),
    STICKY("sticky"),
    ;

    override fun toString(): String = value
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