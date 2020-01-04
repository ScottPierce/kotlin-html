// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderRightWidth(value: Dimension) {
    writeStyleProperty("border-right-width", value)
}

fun BaseStyleContext.borderRightWidth(value: BorderStyle) {
    writeStyleProperty("border-right-width", value)
}

fun StyleContext.borderRightWidth(value: Dimension) {
    writeStyleProperty("border-right-width", value)
}

fun StyleContext.borderRightWidth(value: BorderStyle) {
    writeStyleProperty("border-right-width", value)
}

fun InlineStyleContext.borderRightWidth(value: Dimension) {
    writeStyleProperty("border-right-width", value)
}

fun InlineStyleContext.borderRightWidth(value: BorderStyle) {
    writeStyleProperty("border-right-width", value)
}
