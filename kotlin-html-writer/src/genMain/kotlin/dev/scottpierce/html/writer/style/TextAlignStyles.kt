// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.textAlign(value: TextAlign) {
    writeStyleProperty("text-align", value)
}

fun InlineStyleContext.textAlign(value: TextAlign) {
    writeStyleProperty("text-align", value)
}

enum class TextAlign(
    val value: String
) {
    LEFT("left"),

    RIGHT("right"),

    CENTER("center"),

    JUSTIFY("justify"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
