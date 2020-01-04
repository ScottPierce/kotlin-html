// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderRightStyle(value: BorderStyle) {
    writeStyleProperty("border-right-style", value)
}

fun StyleContext.borderRightStyle(value: BorderStyle) {
    writeStyleProperty("border-right-style", value)
}

fun InlineStyleContext.borderRightStyle(value: BorderStyle) {
    writeStyleProperty("border-right-style", value)
}
