// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Int
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.zIndex(value: Int) {
    writeStyleProperty("z-index", value)
}

fun BaseStyleContext.zIndex(value: ZIndex) {
    writeStyleProperty("z-index", value)
}

fun StyleContext.zIndex(value: Int) {
    writeStyleProperty("z-index", value)
}

fun StyleContext.zIndex(value: ZIndex) {
    writeStyleProperty("z-index", value)
}

fun InlineStyleContext.zIndex(value: Int) {
    writeStyleProperty("z-index", value)
}

fun InlineStyleContext.zIndex(value: ZIndex) {
    writeStyleProperty("z-index", value)
}

enum class ZIndex(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
