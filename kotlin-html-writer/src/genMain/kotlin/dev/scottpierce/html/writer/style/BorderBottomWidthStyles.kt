// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderBottomWidth(value: Dimension) {
    writeStyleProperty("border-bottom-width", value)
}

fun BaseStyleContext.borderBottomWidth(value: BorderStyle) {
    writeStyleProperty("border-bottom-width", value)
}

fun StyleContext.borderBottomWidth(value: Dimension) {
    writeStyleProperty("border-bottom-width", value)
}

fun StyleContext.borderBottomWidth(value: BorderStyle) {
    writeStyleProperty("border-bottom-width", value)
}

fun InlineStyleContext.borderBottomWidth(value: Dimension) {
    writeStyleProperty("border-bottom-width", value)
}

fun InlineStyleContext.borderBottomWidth(value: BorderStyle) {
    writeStyleProperty("border-bottom-width", value)
}
