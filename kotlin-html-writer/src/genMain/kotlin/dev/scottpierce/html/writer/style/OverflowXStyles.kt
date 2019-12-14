// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.overflowX(value: Dimension) {
    writeStyleProperty("overflow-x", value)
}

fun BaseStyleContext.overflowX(value: Overflow) {
    writeStyleProperty("overflow-x", value)
}

fun StyleContext.overflowX(value: Dimension) {
    writeStyleProperty("overflow-x", value)
}

fun StyleContext.overflowX(value: Overflow) {
    writeStyleProperty("overflow-x", value)
}

fun InlineStyleContext.overflowX(value: Dimension) {
    writeStyleProperty("overflow-x", value)
}

fun InlineStyleContext.overflowX(value: Overflow) {
    writeStyleProperty("overflow-x", value)
}
