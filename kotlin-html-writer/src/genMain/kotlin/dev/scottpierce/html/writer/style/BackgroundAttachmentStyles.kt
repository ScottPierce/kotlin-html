// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundAttachment(value: BackgroundAttachment) {
    writeStyleProperty("background-attachment", value)
}

fun StyleContext.backgroundAttachment(value: BackgroundAttachment) {
    writeStyleProperty("background-attachment", value)
}

fun InlineStyleContext.backgroundAttachment(value: BackgroundAttachment) {
    writeStyleProperty("background-attachment", value)
}

enum class BackgroundAttachment(
    val value: String
) {
    SCROLL("scroll"),

    FIXED("fixed"),

    LOCAL("local"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
