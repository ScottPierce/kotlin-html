// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.textDecorationLine(value: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", value)
}

fun BaseStyleContext.textDecorationLine(vararg lines: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "))
}

enum class TextDecorationLine(
    val value: String
) {
    NONE("none"),

    UNDERLINE("underline"),

    OVERLINE("overline"),

    LINE_THROUGH("line-through"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
