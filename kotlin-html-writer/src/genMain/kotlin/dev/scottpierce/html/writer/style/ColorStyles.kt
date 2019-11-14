// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun StyleContext.color(color: Color) {
    writeStyleProperty("color", color)
}

fun StyleContext.color(hexString: String) {
    writeStyleProperty("color", Color(hexString))
}

fun StyleContext.color(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("color", Color(r, g, b))
}

fun StyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("color", Color(r, g, b, a))
}

fun InlineStyleContext.color(color: Color) {
    writeStyleProperty("color", color)
}

fun InlineStyleContext.color(hexString: String) {
    writeStyleProperty("color", Color(hexString))
}

fun InlineStyleContext.color(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("color", Color(r, g, b))
}

fun InlineStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("color", Color(r, g, b, a))
}
