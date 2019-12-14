// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.flexBasis(value: Dimension) {
    writeStyleProperty("flex-basis", value)
}

fun BaseStyleContext.flexBasis(value: FlexBasis) {
    writeStyleProperty("flex-basis", value)
}

fun StyleContext.flexBasis(value: Dimension) {
    writeStyleProperty("flex-basis", value)
}

fun StyleContext.flexBasis(value: FlexBasis) {
    writeStyleProperty("flex-basis", value)
}

fun InlineStyleContext.flexBasis(value: Dimension) {
    writeStyleProperty("flex-basis", value)
}

fun InlineStyleContext.flexBasis(value: FlexBasis) {
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
