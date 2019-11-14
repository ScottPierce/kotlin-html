// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun StyleContext.padding(value: Dimension) {
    writeStyleProperty("padding", value)
}

fun StyleContext.padding(y: Dimension, x: Dimension) {
    writeStyleProperty("padding", """$y $x""")
}

fun StyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension
) {
    writeStyleProperty("padding", """$top $x $bottom""")
}

fun StyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension
) {
    writeStyleProperty("padding", """$top $right $bottom $left""")
}

fun StyleContext.padding(value: CssValue) {
    writeStyleProperty("padding", value)
}

fun InlineStyleContext.padding(value: Dimension) {
    writeStyleProperty("padding", value)
}

fun InlineStyleContext.padding(y: Dimension, x: Dimension) {
    writeStyleProperty("padding", """$y $x""")
}

fun InlineStyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension
) {
    writeStyleProperty("padding", """$top $x $bottom""")
}

fun InlineStyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension
) {
    writeStyleProperty("padding", """$top $right $bottom $left""")
}

fun InlineStyleContext.padding(value: CssValue) {
    writeStyleProperty("padding", value)
}
