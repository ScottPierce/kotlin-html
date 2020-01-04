// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderLeftStyle(value: BorderStyle) {
    writeStyleProperty("border-left-style", value)
}

fun StyleContext.borderLeftStyle(value: BorderStyle) {
    writeStyleProperty("border-left-style", value)
}

fun InlineStyleContext.borderLeftStyle(value: BorderStyle) {
    writeStyleProperty("border-left-style", value)
}
