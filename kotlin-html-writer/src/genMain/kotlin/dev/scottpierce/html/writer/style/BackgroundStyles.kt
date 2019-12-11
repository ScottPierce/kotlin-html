// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.background(color: Color) {
    writeStyleProperty("background", color)
}

fun BaseStyleContext.background(color: Color, image: BackgroundImage) {
    writeStyleProperty("background", """$color $image""")
}

fun BaseStyleContext.background(color: String) {
    writeStyleProperty("background", color)
}

fun StyleContext.background(color: Color) {
    writeStyleProperty("background", color)
}

fun StyleContext.background(color: Color, image: BackgroundImage) {
    writeStyleProperty("background", """$color $image""")
}

fun StyleContext.background(color: String) {
    writeStyleProperty("background", color)
}

fun InlineStyleContext.background(color: Color) {
    writeStyleProperty("background", color)
}

fun InlineStyleContext.background(color: Color, image: BackgroundImage) {
    writeStyleProperty("background", """$color $image""")
}

fun InlineStyleContext.background(color: String) {
    writeStyleProperty("background", color)
}
