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

fun BaseStyleContext.borderRightColor(color: Color) {
    writeStyleProperty("border-right-color", color)
}

fun BaseStyleContext.borderRightColor(hexString: String) {
    writeStyleProperty("border-right-color", Color(hexString))
}

fun BaseStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-right-color", Color(r, g, b))
}

fun BaseStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a))
}

fun StyleContext.borderRightColor(color: Color) {
    writeStyleProperty("border-right-color", color)
}

fun StyleContext.borderRightColor(hexString: String) {
    writeStyleProperty("border-right-color", Color(hexString))
}

fun StyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-right-color", Color(r, g, b))
}

fun StyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a))
}

fun InlineStyleContext.borderRightColor(color: Color) {
    writeStyleProperty("border-right-color", color)
}

fun InlineStyleContext.borderRightColor(hexString: String) {
    writeStyleProperty("border-right-color", Color(hexString))
}

fun InlineStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-right-color", Color(r, g, b))
}

fun InlineStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a))
}
