// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun StyleContext.textDecorationColor(color: Color) {
    writeStyleProperty("text-decoration-color", color)
}

fun StyleContext.textDecorationColor(hexString: String) {
    writeStyleProperty("text-decoration-color", Color(hexString))
}

fun StyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b))
}

fun StyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b, a))
}

fun InlineStyleContext.textDecorationColor(color: Color) {
    writeStyleProperty("text-decoration-color", color)
}

fun InlineStyleContext.textDecorationColor(hexString: String) {
    writeStyleProperty("text-decoration-color", Color(hexString))
}

fun InlineStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b))
}

fun InlineStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b, a))
}