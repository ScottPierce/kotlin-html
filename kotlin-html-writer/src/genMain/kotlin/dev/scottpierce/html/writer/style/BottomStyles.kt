// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.bottom(value: Dimension) {
    writeStyleProperty("bottom", value)
}

fun BaseStyleContext.bottom(value: Bottom) {
    writeStyleProperty("bottom", value)
}

enum class Bottom(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
