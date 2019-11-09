// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", "url('$url')")
}

fun BaseStyleContext.backgroundImage(image: BackgroundImage) {
    writeStyleProperty("background-image", image)
}

fun BaseStyleContext.backgroundImage(image: BackgroundImage, vararg images: BackgroundImage) {
    writeStyleProperty("background-image",
            "$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}")
}
