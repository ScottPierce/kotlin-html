// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.outlineColor(color: Color) {
    writeStyleProperty("outline-color", color)
}

fun BaseStyleContext.outlineColor(hexString: String) {
    writeStyleProperty("outline-color", Color.colorString(hexString))
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("outline-color", Color.colorString(r, g, b))
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("outline-color", Color.colorString(r, g, b, a))
}