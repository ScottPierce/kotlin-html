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

fun BaseStyleContext.borderTopColor(color: Color) {
    writeStyleProperty("border-top-color", color)
}

fun BaseStyleContext.borderTopColor(hexString: String) {
    writeStyleProperty("border-top-color", Color(hexString))
}

fun BaseStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-top-color", Color(r, g, b))
}

fun BaseStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a))
}

fun StyleContext.borderTopColor(color: Color) {
    writeStyleProperty("border-top-color", color)
}

fun StyleContext.borderTopColor(hexString: String) {
    writeStyleProperty("border-top-color", Color(hexString))
}

fun StyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-top-color", Color(r, g, b))
}

fun StyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a))
}

fun InlineStyleContext.borderTopColor(color: Color) {
    writeStyleProperty("border-top-color", color)
}

fun InlineStyleContext.borderTopColor(hexString: String) {
    writeStyleProperty("border-top-color", Color(hexString))
}

fun InlineStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("border-top-color", Color(r, g, b))
}

fun InlineStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a))
}
