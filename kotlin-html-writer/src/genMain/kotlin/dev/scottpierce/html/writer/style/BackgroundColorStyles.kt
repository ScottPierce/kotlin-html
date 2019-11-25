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
    writeStyleProperty("background-color", Color(hexString))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("background-color", Color(r, g, b))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("background-color", Color(r, g, b, a))
}

fun StyleContext.backgroundColor(color: Color) {
    writeStyleProperty("background-color", color)
}

fun StyleContext.backgroundColor(hexString: String) {
    writeStyleProperty("background-color", Color(hexString))
}

fun StyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("background-color", Color(r, g, b))
}

fun StyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("background-color", Color(r, g, b, a))
}

fun InlineStyleContext.backgroundColor(color: Color) {
    writeStyleProperty("background-color", color)
}

fun InlineStyleContext.backgroundColor(hexString: String) {
    writeStyleProperty("background-color", Color(hexString))
}

fun InlineStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("background-color", Color(r, g, b))
}

fun InlineStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("background-color", Color(r, g, b, a))
}
