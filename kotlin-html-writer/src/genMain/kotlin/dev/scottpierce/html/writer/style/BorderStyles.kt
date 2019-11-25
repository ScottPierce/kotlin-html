// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun BaseStyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun BaseStyleContext.border(value: Border) {
    writeStyleProperty("border", value)
}

fun StyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun StyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun StyleContext.border(value: Border) {
    writeStyleProperty("border", value)
}

fun InlineStyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun InlineStyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border", """$width $style $color""")
}

fun InlineStyleContext.border(value: Border) {
    writeStyleProperty("border", value)
}

enum class Border(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit"),

    NONE("none");

    override fun toString() = value
}
