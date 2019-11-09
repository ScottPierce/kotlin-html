// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.fill(color: Color) {
    writeStyleProperty("fill", color)
}

fun BaseStyleContext.fill(hexString: String) {
    writeStyleProperty("fill", Color(hexString))
}

fun BaseStyleContext.fill(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("fill", Color(r, g, b))
}

fun BaseStyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("fill", Color(r, g, b, a))
}
