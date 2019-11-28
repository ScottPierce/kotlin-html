// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.overflowY(value: Dimension) {
    writeStyleProperty("overflow-y", value)
}

fun BaseStyleContext.overflowY(value: Overflow) {
    writeStyleProperty("overflow-y", value)
}

fun StyleContext.overflowY(value: Dimension) {
    writeStyleProperty("overflow-y", value)
}

fun StyleContext.overflowY(value: Overflow) {
    writeStyleProperty("overflow-y", value)
}

fun InlineStyleContext.overflowY(value: Dimension) {
    writeStyleProperty("overflow-y", value)
}

fun InlineStyleContext.overflowY(value: Overflow) {
    writeStyleProperty("overflow-y", value)
}
