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
    writeStyleProperty("outline-color", Color(hexString))
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("outline-color", Color(r, g, b))
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("outline-color", Color(r, g, b, a))
}

fun StyleContext.outlineColor(color: Color) {
    writeStyleProperty("outline-color", color)
}

fun StyleContext.outlineColor(hexString: String) {
    writeStyleProperty("outline-color", Color(hexString))
}

fun StyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("outline-color", Color(r, g, b))
}

fun StyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("outline-color", Color(r, g, b, a))
}

fun InlineStyleContext.outlineColor(color: Color) {
    writeStyleProperty("outline-color", color)
}

fun InlineStyleContext.outlineColor(hexString: String) {
    writeStyleProperty("outline-color", Color(hexString))
}

fun InlineStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("outline-color", Color(r, g, b))
}

fun InlineStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("outline-color", Color(r, g, b, a))
}
