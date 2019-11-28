// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Int
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.fontWeight(value: Int) {
    writeStyleProperty("font-weight", value)
}

fun BaseStyleContext.fontWeight(value: FontWeight) {
    writeStyleProperty("font-weight", value)
}

fun StyleContext.fontWeight(value: Int) {
    writeStyleProperty("font-weight", value)
}

fun StyleContext.fontWeight(value: FontWeight) {
    writeStyleProperty("font-weight", value)
}

fun InlineStyleContext.fontWeight(value: Int) {
    writeStyleProperty("font-weight", value)
}

fun InlineStyleContext.fontWeight(value: FontWeight) {
    writeStyleProperty("font-weight", value)
}

enum class FontWeight(
    val value: String
) {
    NORMAL("normal"),

    BOLD("bold"),

    BOLDER("bolder"),

    LIGHTER("lighter"),

    INHERIT("inherit"),

    INITIAL("initial");

    override fun toString() = value
}
