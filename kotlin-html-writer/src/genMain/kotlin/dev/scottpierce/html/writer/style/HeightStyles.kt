// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.height(value: Dimension) {
    writeStyleProperty("height", value)
}

fun StyleContext.height(value: Height) {
    writeStyleProperty("height", value)
}

fun InlineStyleContext.height(value: Dimension) {
    writeStyleProperty("height", value)
}

fun InlineStyleContext.height(value: Height) {
    writeStyleProperty("height", value)
}

enum class Height(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
