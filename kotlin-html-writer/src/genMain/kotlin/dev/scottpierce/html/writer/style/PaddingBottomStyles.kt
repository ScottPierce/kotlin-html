// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.paddingBottom(value: Dimension) {
    writeStyleProperty("padding-bottom", value)
}

fun BaseStyleContext.paddingBottom(value: CssValue) {
    writeStyleProperty("padding-bottom", value)
}

fun StyleContext.paddingBottom(value: Dimension) {
    writeStyleProperty("padding-bottom", value)
}

fun StyleContext.paddingBottom(value: CssValue) {
    writeStyleProperty("padding-bottom", value)
}

fun InlineStyleContext.paddingBottom(value: Dimension) {
    writeStyleProperty("padding-bottom", value)
}

fun InlineStyleContext.paddingBottom(value: CssValue) {
    writeStyleProperty("padding-bottom", value)
}
