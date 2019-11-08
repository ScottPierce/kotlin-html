// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.fontSize(value: Dimension) {
    writeStyleProperty("font-size", value)
}

fun BaseStyleContext.fontSize(value: FontSize) {
    writeStyleProperty("font-size", value)
}

enum class FontSize(
    val value: String
) {
    XX_SMALL("xx-small"),

    X_SMALL("x-small"),

    SMALLER("smaller"),

    SMALL("small"),

    LARGE("large"),

    LARGER("larger"),

    X_LARGE("x-large"),

    XX_LARGE("xx-large"),

    INHERIT("inherit"),

    INITIAL("initial");

    override fun toString() = value
}
