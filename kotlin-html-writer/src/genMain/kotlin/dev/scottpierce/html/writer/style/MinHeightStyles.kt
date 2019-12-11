// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.minHeight(value: Dimension) {
    writeStyleProperty("min-height", value)
}

fun BaseStyleContext.minHeight(value: CssValue) {
    writeStyleProperty("min-height", value)
}

fun StyleContext.minHeight(value: Dimension) {
    writeStyleProperty("min-height", value)
}

fun StyleContext.minHeight(value: CssValue) {
    writeStyleProperty("min-height", value)
}

fun InlineStyleContext.minHeight(value: Dimension) {
    writeStyleProperty("min-height", value)
}

fun InlineStyleContext.minHeight(value: CssValue) {
    writeStyleProperty("min-height", value)
}
