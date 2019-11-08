// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.flexBasis(value: Number) {
    writeStyleProperty("flex-basis", value)
}

fun BaseStyleContext.flexBasis(value: FlexBasis) {
    writeStyleProperty("flex-basis", value)
}

enum class FlexBasis(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
