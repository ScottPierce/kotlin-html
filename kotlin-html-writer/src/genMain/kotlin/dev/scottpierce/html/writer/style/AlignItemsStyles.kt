// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.alignItems(value: AlignItems) {
    writeStyleProperty("align-items", value)
}

enum class AlignItems(
    val value: String
) {
    BASELINE("baseline"),

    CENTER("center"),

    FLEX_START("flex-start"),

    FLEX_END("flex-end"),

    STRETCH("stretch"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
