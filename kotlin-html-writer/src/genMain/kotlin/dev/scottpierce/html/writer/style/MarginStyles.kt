// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun BaseStyleContext.margin(value: Dimension) {
    writeStyleProperty("margin", value)
}

fun BaseStyleContext.margin(y: Dimension, x: Dimension) {
    writeStyleProperty("margin", "$y $x")
}

fun BaseStyleContext.margin(
    top: Dimension,
    x: Dimension,
    bottom: Dimension
) {
    writeStyleProperty("margin", "$top $x $bottom")
}

fun BaseStyleContext.margin(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension
) {
    writeStyleProperty("margin", "$top $right $bottom $left")
}

fun BaseStyleContext.margin(value: CssValue) {
    writeStyleProperty("margin", value)
}
