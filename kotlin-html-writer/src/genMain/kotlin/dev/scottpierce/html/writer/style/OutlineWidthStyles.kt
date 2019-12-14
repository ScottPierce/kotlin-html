// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.outlineWidth(value: Dimension) {
    writeStyleProperty("outline-width", value)
}

fun BaseStyleContext.outlineWidth(value: OutlineWidth) {
    writeStyleProperty("outline-width", value)
}

fun StyleContext.outlineWidth(value: Dimension) {
    writeStyleProperty("outline-width", value)
}

fun StyleContext.outlineWidth(value: OutlineWidth) {
    writeStyleProperty("outline-width", value)
}

fun InlineStyleContext.outlineWidth(value: Dimension) {
    writeStyleProperty("outline-width", value)
}

fun InlineStyleContext.outlineWidth(value: OutlineWidth) {
    writeStyleProperty("outline-width", value)
}

enum class OutlineWidth(
    val value: String
) {
    MEDIUM("medium"),

    THIN("thin"),

    THICK("thick"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
