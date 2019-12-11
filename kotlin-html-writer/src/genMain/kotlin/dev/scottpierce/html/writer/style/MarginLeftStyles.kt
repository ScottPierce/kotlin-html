// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.marginLeft(value: Dimension) {
    writeStyleProperty("margin-left", value)
}

fun BaseStyleContext.marginLeft(value: CssValue) {
    writeStyleProperty("margin-left", value)
}

fun StyleContext.marginLeft(value: Dimension) {
    writeStyleProperty("margin-left", value)
}

fun StyleContext.marginLeft(value: CssValue) {
    writeStyleProperty("margin-left", value)
}

fun InlineStyleContext.marginLeft(value: Dimension) {
    writeStyleProperty("margin-left", value)
}

fun InlineStyleContext.marginLeft(value: CssValue) {
    writeStyleProperty("margin-left", value)
}
