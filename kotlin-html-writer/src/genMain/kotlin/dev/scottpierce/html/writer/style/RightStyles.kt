// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.right(value: Dimension) {
    writeStyleProperty("right", value)
}

fun StyleContext.right(value: Right) {
    writeStyleProperty("right", value)
}

fun InlineStyleContext.right(value: Dimension) {
    writeStyleProperty("right", value)
}

fun InlineStyleContext.right(value: Right) {
    writeStyleProperty("right", value)
}

enum class Right(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
