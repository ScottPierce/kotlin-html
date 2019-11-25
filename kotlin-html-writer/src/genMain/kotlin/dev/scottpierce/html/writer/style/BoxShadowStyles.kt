// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.boxShadow(boxShadow: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadow)
}

fun BaseStyleContext.boxShadow(vararg boxShadows: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadows.joinToString())
}

fun BaseStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset))
}

fun BaseStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset))
}

fun StyleContext.boxShadow(boxShadow: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadow)
}

fun StyleContext.boxShadow(vararg boxShadows: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadows.joinToString())
}

fun StyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset))
}

fun StyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset))
}

fun InlineStyleContext.boxShadow(boxShadow: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadow)
}

fun InlineStyleContext.boxShadow(vararg boxShadows: BoxShadow) {
    writeStyleProperty("box-shadow", boxShadows.joinToString())
}

fun InlineStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset))
}

fun InlineStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset))
}
