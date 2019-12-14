// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.borderWidth(value: Dimension) {
    writeStyleProperty("border-width", value)
}

fun BaseStyleContext.borderWidth(value: BorderWidth) {
    writeStyleProperty("border-width", value)
}

fun StyleContext.borderWidth(value: Dimension) {
    writeStyleProperty("border-width", value)
}

fun StyleContext.borderWidth(value: BorderWidth) {
    writeStyleProperty("border-width", value)
}

fun InlineStyleContext.borderWidth(value: Dimension) {
    writeStyleProperty("border-width", value)
}

fun InlineStyleContext.borderWidth(value: BorderWidth) {
    writeStyleProperty("border-width", value)
}

enum class BorderWidth(
    val value: String
) {
    MEDIUM("medium"),

    THIN("thin"),

    THICK("thick"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
