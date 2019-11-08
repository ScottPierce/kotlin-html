// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Boolean
import kotlin.Number
import kotlin.Suppress

fun BaseStyleContext.boxShadow(boxShadow: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadow)
}

fun BaseStyleContext.boxShadow(vararg boxShadows: BoxShadow) {
    writeStyleProperty("box-shadow", writeBoxShadows(boxShadows))
}

fun BaseStyleContext.boxShadow(
    hOffset: Number,
    vOffset: Number,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset))
}

fun BaseStyleContext.boxShadow(
    hOffset: Number,
    vOffset: Number,
    color: Color,
    blur: Number,
    spread: Number? = null,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            blur = blur, spread = spread, inset = inset))
}
