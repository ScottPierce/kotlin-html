// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.right(value: Dimension) {
    writeStyleProperty("right", value)
}

fun BaseStyleContext.right(value: Right) {
    writeStyleProperty("right", value)
}

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
