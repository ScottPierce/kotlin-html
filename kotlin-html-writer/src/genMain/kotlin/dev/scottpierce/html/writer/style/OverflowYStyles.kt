// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun BaseStyleContext.overflowY(value: Dimension) {
    writeStyleProperty("overflow-y", value)
}

fun BaseStyleContext.overflowY(value: Overflow) {
    writeStyleProperty("overflow-y", value)
}