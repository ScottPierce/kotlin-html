// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundColor(color: Color) {
    writeStyleProperty("background-color", color)
}

fun BaseStyleContext.backgroundColor(hexString: String) {
    writeStyleProperty("background-color", Color.colorString(hexString))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("background-color", Color.colorString(r, g, b))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("background-color", Color.colorString(r, g, b, a))
}
