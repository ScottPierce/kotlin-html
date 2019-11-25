// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.justifyContent(value: JustifyContent) {
    writeStyleProperty("justify-content", value)
}

fun StyleContext.justifyContent(value: JustifyContent) {
    writeStyleProperty("justify-content", value)
}

fun InlineStyleContext.justifyContent(value: JustifyContent) {
    writeStyleProperty("justify-content", value)
}

enum class JustifyContent(
    val value: String
) {
    CENTER("center"),

    FLEX_END("flex-end"),

    FLEX_START("flex-start"),

    SPACE_AROUND("space-around"),

    SPACE_BETWEEN("space-between"),

    SPACE_EVENLY("space-evenly"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
