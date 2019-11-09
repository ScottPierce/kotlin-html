// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.flexWrap(value: FlexWrap) {
    writeStyleProperty("flex-wrap", value)
}

enum class FlexWrap(
    val value: String
) {
    NOWRAP("nowrap"),

    WRAP("wrap"),

    WRAP_REVERSE("wrap-reverse"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
