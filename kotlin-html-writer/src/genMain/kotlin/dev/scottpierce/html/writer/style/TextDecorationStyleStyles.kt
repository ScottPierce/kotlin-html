// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.textDecorationStyle(value: TextDecorationStyle) {
    writeStyleProperty("text-decoration-style", value)
}

fun StyleContext.textDecorationStyle(value: TextDecorationStyle) {
    writeStyleProperty("text-decoration-style", value)
}

fun InlineStyleContext.textDecorationStyle(value: TextDecorationStyle) {
    writeStyleProperty("text-decoration-style", value)
}

enum class TextDecorationStyle(
    val value: String
) {
    SOLID("solid"),

    DOUBLE("double"),

    DOTTED("dotted"),

    DASHED("dashed"),

    WAVY("wavy"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
