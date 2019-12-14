// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.paddingLeft(value: Dimension) {
    writeStyleProperty("padding-left", value)
}

fun BaseStyleContext.paddingLeft(value: CssValue) {
    writeStyleProperty("padding-left", value)
}

fun StyleContext.paddingLeft(value: Dimension) {
    writeStyleProperty("padding-left", value)
}

fun StyleContext.paddingLeft(value: CssValue) {
    writeStyleProperty("padding-left", value)
}

fun InlineStyleContext.paddingLeft(value: Dimension) {
    writeStyleProperty("padding-left", value)
}

fun InlineStyleContext.paddingLeft(value: CssValue) {
    writeStyleProperty("padding-left", value)
}
