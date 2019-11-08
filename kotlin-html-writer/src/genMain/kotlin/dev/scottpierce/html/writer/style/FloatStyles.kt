// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.float(value: Float) {
    writeStyleProperty("float", value)
}

enum class Float(
    val value: String
) {
    NONE("none"),

    LEFT("left"),

    RIGHT("right"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
