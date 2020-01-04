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

fun BaseStyleContext.borderBottomColor(color: Color) {
    writeStyleProperty("border-bottom-color", color)
}

fun BaseStyleContext.borderBottomColor(hexString: String) {
    writeStyleProperty("border-bottom-color", Color(hexString))
}

fun BaseStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b))
}

fun BaseStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a))
}

fun StyleContext.borderBottomColor(color: Color) {
    writeStyleProperty("border-bottom-color", color)
}

fun StyleContext.borderBottomColor(hexString: String) {
    writeStyleProperty("border-bottom-color", Color(hexString))
}

fun StyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b))
}

fun StyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a))
}

fun InlineStyleContext.borderBottomColor(color: Color) {
    writeStyleProperty("border-bottom-color", color)
}

fun InlineStyleContext.borderBottomColor(hexString: String) {
    writeStyleProperty("border-bottom-color", Color(hexString))
}

fun InlineStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b))
}

fun InlineStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a))
}
