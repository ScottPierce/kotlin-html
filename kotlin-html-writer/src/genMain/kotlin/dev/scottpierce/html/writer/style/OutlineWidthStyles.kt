// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.outlineWidth(value: Dimension) {
    writeStyleProperty("outline-width", value)
}

fun BaseStyleContext.outlineWidth(value: OutlineWidth) {
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