// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.letterSpacing(value: Dimension) {
    writeStyleProperty("letter-spacing", value)
}

fun BaseStyleContext.letterSpacing(value: LetterSpacing) {
    writeStyleProperty("letter-spacing", value)
}

fun StyleContext.letterSpacing(value: Dimension) {
    writeStyleProperty("letter-spacing", value)
}

fun StyleContext.letterSpacing(value: LetterSpacing) {
    writeStyleProperty("letter-spacing", value)
}

fun InlineStyleContext.letterSpacing(value: Dimension) {
    writeStyleProperty("letter-spacing", value)
}

fun InlineStyleContext.letterSpacing(value: LetterSpacing) {
    writeStyleProperty("letter-spacing", value)
}

enum class LetterSpacing(
    val value: String
) {
    NORMAL("normal"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
