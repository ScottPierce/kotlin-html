// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.animationDuration(value: String) {
    writeStyleProperty("animation-duration", value)
}

fun BaseStyleContext.animationDuration(value: CssValue) {
    writeStyleProperty("animation-duration", value)
}
