// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun BaseStyleContext.outline(
    width: Dimension,
    style: OutlineStyle,
    color: Color? = null
) {
    writeStyleProperty("outline",
            "$width $style${if (color == null) "" else " $color"}")
}

fun BaseStyleContext.outline(value: CssValue) {
    writeStyleProperty("outline", value)
}
