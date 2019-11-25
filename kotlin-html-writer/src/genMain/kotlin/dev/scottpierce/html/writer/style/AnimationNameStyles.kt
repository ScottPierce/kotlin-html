// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.animationName(value: String) {
    writeStyleProperty("animation-name", value)
}

fun BaseStyleContext.animationName(value: AnimationName) {
    writeStyleProperty("animation-name", value)
}

fun StyleContext.animationName(value: String) {
    writeStyleProperty("animation-name", value)
}

fun StyleContext.animationName(value: AnimationName) {
    writeStyleProperty("animation-name", value)
}

fun InlineStyleContext.animationName(value: String) {
    writeStyleProperty("animation-name", value)
}

fun InlineStyleContext.animationName(value: AnimationName) {
    writeStyleProperty("animation-name", value)
}

enum class AnimationName(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
