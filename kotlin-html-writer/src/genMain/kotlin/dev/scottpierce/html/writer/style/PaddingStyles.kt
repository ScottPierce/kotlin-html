// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun BaseStyleContext.padding(value: Dimension) {
    writeStyleProperty("padding", value)
}

fun BaseStyleContext.padding(y: Dimension, x: Dimension) {
    writeStyleProperty("padding", "$y $x")
}

fun BaseStyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension
) {
    writeStyleProperty("padding", "$top $x $bottom")
}

fun BaseStyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension
) {
    writeStyleProperty("padding", "$top $right $bottom $left")
}

fun BaseStyleContext.padding(value: CssValue) {
    writeStyleProperty("padding", value)
}
