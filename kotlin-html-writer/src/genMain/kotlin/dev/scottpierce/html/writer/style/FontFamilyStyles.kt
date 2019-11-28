// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.fontFamily(value: String) {
    writeStyleProperty("font-family", value)
}

fun BaseStyleContext.fontFamily(value: CssValue) {
    writeStyleProperty("font-family", value)
}

fun StyleContext.fontFamily(value: String) {
    writeStyleProperty("font-family", value)
}

fun StyleContext.fontFamily(value: CssValue) {
    writeStyleProperty("font-family", value)
}

fun InlineStyleContext.fontFamily(value: String) {
    writeStyleProperty("font-family", value)
}

fun InlineStyleContext.fontFamily(value: CssValue) {
    writeStyleProperty("font-family", value)
}
