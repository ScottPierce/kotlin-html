// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", "url('$url')")
}

fun BaseStyleContext.backgroundImage(vararg urls: String) {
    writeStyleProperty("background-image", writeBackgroundImages(urls))
}
