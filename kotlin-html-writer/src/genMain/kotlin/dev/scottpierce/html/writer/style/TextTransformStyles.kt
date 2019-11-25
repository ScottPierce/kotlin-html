// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.textTransform(value: TextTransform) {
    writeStyleProperty("text-transform", value)
}

fun StyleContext.textTransform(value: TextTransform) {
    writeStyleProperty("text-transform", value)
}

fun InlineStyleContext.textTransform(value: TextTransform) {
    writeStyleProperty("text-transform", value)
}

enum class TextTransform(
    val value: String
) {
    NONE("none"),

    CAPITALIZE("capitalize"),

    UPPERCASE("uppercase"),

    LOWERCASE("lowercase"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
