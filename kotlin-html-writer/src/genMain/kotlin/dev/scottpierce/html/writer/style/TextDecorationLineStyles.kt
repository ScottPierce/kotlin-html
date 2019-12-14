// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.textDecorationLine(value: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", value)
}

fun BaseStyleContext.textDecorationLine(vararg lines: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "))
}

fun StyleContext.textDecorationLine(value: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", value)
}

fun StyleContext.textDecorationLine(vararg lines: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "))
}

fun InlineStyleContext.textDecorationLine(value: TextDecorationLine) {
    writeStyleProperty("text-decoration-line", value)
}

fun InlineStyleContext.textDecorationLine(vararg lines: TextDecorationLine) {
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
