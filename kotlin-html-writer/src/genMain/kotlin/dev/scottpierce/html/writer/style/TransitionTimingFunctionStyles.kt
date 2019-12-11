// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.transitionTimingFunction(value: TransitionTimingFunction) {
    writeStyleProperty("transition-timing-function", value)
}

fun StyleContext.transitionTimingFunction(value: TransitionTimingFunction) {
    writeStyleProperty("transition-timing-function", value)
}

fun InlineStyleContext.transitionTimingFunction(value: TransitionTimingFunction) {
    writeStyleProperty("transition-timing-function", value)
}

enum class TransitionTimingFunction(
    val value: String
) {
    LINEAR("linear"),

    EASE("ease"),

    EASE_IN("ease-in"),

    EASE_OUT("ease-out"),

    EASE_IN_OUT("ease-in-out"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
