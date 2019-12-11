// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.maxHeight(value: Dimension) {
    writeStyleProperty("max-height", value)
}

fun BaseStyleContext.maxHeight(value: MaxHeight) {
    writeStyleProperty("max-height", value)
}

fun StyleContext.maxHeight(value: Dimension) {
    writeStyleProperty("max-height", value)
}

fun StyleContext.maxHeight(value: MaxHeight) {
    writeStyleProperty("max-height", value)
}

fun InlineStyleContext.maxHeight(value: Dimension) {
    writeStyleProperty("max-height", value)
}

fun InlineStyleContext.maxHeight(value: MaxHeight) {
    writeStyleProperty("max-height", value)
}

enum class MaxHeight(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
