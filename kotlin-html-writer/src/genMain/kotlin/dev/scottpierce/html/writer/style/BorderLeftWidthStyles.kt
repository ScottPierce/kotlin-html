// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderLeftWidth(value: Dimension) {
    writeStyleProperty("border-left-width", value)
}

fun BaseStyleContext.borderLeftWidth(value: BorderStyle) {
    writeStyleProperty("border-left-width", value)
}

fun StyleContext.borderLeftWidth(value: Dimension) {
    writeStyleProperty("border-left-width", value)
}

fun StyleContext.borderLeftWidth(value: BorderStyle) {
    writeStyleProperty("border-left-width", value)
}

fun InlineStyleContext.borderLeftWidth(value: Dimension) {
    writeStyleProperty("border-left-width", value)
}

fun InlineStyleContext.borderLeftWidth(value: BorderStyle) {
    writeStyleProperty("border-left-width", value)
}
