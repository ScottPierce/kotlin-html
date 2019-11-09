// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.color(color: Color) {
    writeStyleProperty("color", color)
}

fun BaseStyleContext.color(hexString: String) {
    writeStyleProperty("color", Color(hexString))
}

fun BaseStyleContext.color(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("color", Color(r, g, b))
}

fun BaseStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("color", Color(r, g, b, a))
}
