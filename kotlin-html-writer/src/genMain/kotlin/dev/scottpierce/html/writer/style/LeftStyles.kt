// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.left(value: Dimension) {
    writeStyleProperty("left", value)
}

fun StyleContext.left(value: Left) {
    writeStyleProperty("left", value)
}

fun InlineStyleContext.left(value: Dimension) {
    writeStyleProperty("left", value)
}

fun InlineStyleContext.left(value: Left) {
    writeStyleProperty("left", value)
}

enum class Left(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
