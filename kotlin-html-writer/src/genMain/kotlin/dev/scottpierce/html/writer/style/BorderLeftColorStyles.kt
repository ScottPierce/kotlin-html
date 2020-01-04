// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.borderLeftColor(color: Color) {
    writeStyleProperty("border-left-color", color)
}

fun BaseStyleContext.borderLeftColor(hexString: String) {
    writeStyleProperty("border-left-color", Color(hexString))
}

fun BaseStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-left-color", Color(r, g, b))
}

fun BaseStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a))
}

fun StyleContext.borderLeftColor(color: Color) {
    writeStyleProperty("border-left-color", color)
}

fun StyleContext.borderLeftColor(hexString: String) {
    writeStyleProperty("border-left-color", Color(hexString))
}

fun StyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-left-color", Color(r, g, b))
}

fun StyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a))
}

fun InlineStyleContext.borderLeftColor(color: Color) {
    writeStyleProperty("border-left-color", color)
}

fun InlineStyleContext.borderLeftColor(hexString: String) {
    writeStyleProperty("border-left-color", Color(hexString))
}

fun InlineStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-left-color", Color(r, g, b))
}

fun InlineStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a))
}
