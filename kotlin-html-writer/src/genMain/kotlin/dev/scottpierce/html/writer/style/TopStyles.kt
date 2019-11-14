// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.top(value: Dimension) {
    writeStyleProperty("top", value)
}

fun StyleContext.top(value: Top) {
    writeStyleProperty("top", value)
}

fun InlineStyleContext.top(value: Dimension) {
    writeStyleProperty("top", value)
}

fun InlineStyleContext.top(value: Top) {
    writeStyleProperty("top", value)
}

enum class Top(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
