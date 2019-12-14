// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.padding(value: Dimension) {
    writeStyleProperty("padding", value)
}

fun BaseStyleContext.padding(y: Dimension, x: Dimension) {
    writeStyleProperty("padding", """$y $x""")
}

fun BaseStyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension
) {
    writeStyleProperty("padding", """$top $x $bottom""")
}

fun BaseStyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension
) {
    writeStyleProperty("padding", """$top $right $bottom $left""")
}

fun BaseStyleContext.padding(value: CssValue) {
    writeStyleProperty("padding", value)
}

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
