// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun StyleContext.borderRadius(value: Dimension) {
    writeStyleProperty("border-radius", value)
}

fun StyleContext.borderRadius(topLeftAndBottomRight: Dimension, topRightAndBottomLeft: Dimension) {
    writeStyleProperty("border-radius", """$topLeftAndBottomRight $topRightAndBottomLeft""")
}

fun StyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension
) {
    writeStyleProperty("border-radius", """$topLeft $topRightAndBottomLeft $bottomRight""")
}

fun StyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension
) {
    writeStyleProperty("border-radius", """$topLeft $topRight $bottomRight $bottomLeft""")
}

fun InlineStyleContext.borderRadius(value: Dimension) {
    writeStyleProperty("border-radius", value)
}

fun InlineStyleContext.borderRadius(topLeftAndBottomRight: Dimension,
        topRightAndBottomLeft: Dimension) {
    writeStyleProperty("border-radius", """$topLeftAndBottomRight $topRightAndBottomLeft""")
}

fun InlineStyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension
) {
    writeStyleProperty("border-radius", """$topLeft $topRightAndBottomLeft $bottomRight""")
}

fun InlineStyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension
) {
    writeStyleProperty("border-radius", """$topLeft $topRight $bottomRight $bottomLeft""")
}
