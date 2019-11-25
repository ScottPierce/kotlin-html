// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundPosition(x: BackgroundPosition, y: BackgroundPosition? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun BaseStyleContext.backgroundPosition(x: Dimension, y: Dimension? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun BaseStyleContext.backgroundPosition(value: CssValue) {
    writeStyleProperty("background-position", value)
}

fun StyleContext.backgroundPosition(x: BackgroundPosition, y: BackgroundPosition? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun StyleContext.backgroundPosition(x: Dimension, y: Dimension? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun StyleContext.backgroundPosition(value: CssValue) {
    writeStyleProperty("background-position", value)
}

fun InlineStyleContext.backgroundPosition(x: BackgroundPosition, y: BackgroundPosition? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun InlineStyleContext.backgroundPosition(x: Dimension, y: Dimension? = null) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""")
}

fun InlineStyleContext.backgroundPosition(value: CssValue) {
    writeStyleProperty("background-position", value)
}

enum class BackgroundPosition(
    val value: String
) {
    LEFT("left"),

    RIGHT("right"),

    TOP("top"),

    BOTTOM("bottom"),

    CENTER("center");

    override fun toString() = value
}
