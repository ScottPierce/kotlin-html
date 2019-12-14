// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Number
import kotlin.Suppress

fun BaseStyleContext.flexGrow(value: Number) {
    writeStyleProperty("flex-grow", value)
}

fun BaseStyleContext.flexGrow(value: CssValue) {
    writeStyleProperty("flex-grow", value)
}

fun StyleContext.flexGrow(value: Number) {
    writeStyleProperty("flex-grow", value)
}

fun StyleContext.flexGrow(value: CssValue) {
    writeStyleProperty("flex-grow", value)
}

fun InlineStyleContext.flexGrow(value: Number) {
    writeStyleProperty("flex-grow", value)
}

fun InlineStyleContext.flexGrow(value: CssValue) {
    writeStyleProperty("flex-grow", value)
}
