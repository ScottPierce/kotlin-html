// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.maxWidth(value: Dimension) {
    writeStyleProperty("max-width", value)
}

fun BaseStyleContext.maxWidth(value: MaxWidth) {
    writeStyleProperty("max-width", value)
}

fun StyleContext.maxWidth(value: Dimension) {
    writeStyleProperty("max-width", value)
}

fun StyleContext.maxWidth(value: MaxWidth) {
    writeStyleProperty("max-width", value)
}

fun InlineStyleContext.maxWidth(value: Dimension) {
    writeStyleProperty("max-width", value)
}

fun InlineStyleContext.maxWidth(value: MaxWidth) {
    writeStyleProperty("max-width", value)
}

enum class MaxWidth(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
