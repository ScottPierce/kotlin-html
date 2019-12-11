// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundClip(value: BackgroundClip) {
    writeStyleProperty("background-clip", value)
}

fun StyleContext.backgroundClip(value: BackgroundClip) {
    writeStyleProperty("background-clip", value)
}

fun InlineStyleContext.backgroundClip(value: BackgroundClip) {
    writeStyleProperty("background-clip", value)
}

enum class BackgroundClip(
    val value: String
) {
    BORDER_BOX("border-box"),

    PADDING_BOX("padding-box"),

    CONTENT_BOX("content-box"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
