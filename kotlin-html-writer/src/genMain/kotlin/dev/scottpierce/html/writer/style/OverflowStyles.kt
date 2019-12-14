// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.overflow(value: Dimension) {
    writeStyleProperty("overflow", value)
}

fun BaseStyleContext.overflow(value: Overflow) {
    writeStyleProperty("overflow", value)
}

fun StyleContext.overflow(value: Dimension) {
    writeStyleProperty("overflow", value)
}

fun StyleContext.overflow(value: Overflow) {
    writeStyleProperty("overflow", value)
}

fun InlineStyleContext.overflow(value: Dimension) {
    writeStyleProperty("overflow", value)
}

fun InlineStyleContext.overflow(value: Overflow) {
    writeStyleProperty("overflow", value)
}

enum class Overflow(
    val value: String
) {
    VISIBLE("visible"),

    HIDDEN("hidden"),

    SCROLL("scroll"),

    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
