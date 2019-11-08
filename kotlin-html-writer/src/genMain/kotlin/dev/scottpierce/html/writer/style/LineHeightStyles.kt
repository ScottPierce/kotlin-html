// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.lineHeight(multiplier: Number) {
    writeStyleProperty("line-height", multiplier)
}

fun BaseStyleContext.lineHeight(value: Dimension) {
    writeStyleProperty("line-height", value)
}

fun BaseStyleContext.lineHeight(value: LineHeight) {
    writeStyleProperty("line-height", value)
}

enum class LineHeight(
    val value: String
) {
    NORMAL("normal"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}