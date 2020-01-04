// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderTopWidth(value: Dimension) {
    writeStyleProperty("border-top-width", value)
}

fun BaseStyleContext.borderTopWidth(value: BorderStyle) {
    writeStyleProperty("border-top-width", value)
}

fun StyleContext.borderTopWidth(value: Dimension) {
    writeStyleProperty("border-top-width", value)
}

fun StyleContext.borderTopWidth(value: BorderStyle) {
    writeStyleProperty("border-top-width", value)
}

fun InlineStyleContext.borderTopWidth(value: Dimension) {
    writeStyleProperty("border-top-width", value)
}

fun InlineStyleContext.borderTopWidth(value: BorderStyle) {
    writeStyleProperty("border-top-width", value)
}
