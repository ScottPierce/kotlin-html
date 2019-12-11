// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", """url('$url')""")
}

fun BaseStyleContext.backgroundImage(image: BackgroundImage) {
    writeStyleProperty("background-image", image)
}

fun BaseStyleContext.backgroundImage(image: BackgroundImage, vararg images: BackgroundImage) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""")
}

fun StyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", """url('$url')""")
}

fun StyleContext.backgroundImage(image: BackgroundImage) {
    writeStyleProperty("background-image", image)
}

fun StyleContext.backgroundImage(image: BackgroundImage, vararg images: BackgroundImage) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""")
}

fun InlineStyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", """url('$url')""")
}

fun InlineStyleContext.backgroundImage(image: BackgroundImage) {
    writeStyleProperty("background-image", image)
}

fun InlineStyleContext.backgroundImage(image: BackgroundImage, vararg images: BackgroundImage) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""")
}
