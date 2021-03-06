// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.overflowX(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}

fun BaseStyleContext.overflowX(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}

fun StyleContext.overflowX(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}

fun StyleContext.overflowX(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}

fun InlineStyleContext.overflowX(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}

fun InlineStyleContext.overflowX(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-x", value, important)
}
