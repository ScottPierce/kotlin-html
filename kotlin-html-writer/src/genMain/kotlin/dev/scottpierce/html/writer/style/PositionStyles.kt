// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.position(value: Position) {
    writeStyleProperty("position", value)
}

fun InlineStyleContext.position(value: Position) {
    writeStyleProperty("position", value)
}

enum class Position(
    val value: String
) {
    STATIC("static"),

    RELATIVE("relative"),

    FIXED("fixed"),

    ABSOLUTE("absolute"),

    STICKY("sticky"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
