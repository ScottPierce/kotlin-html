// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress
import kotlin.time.Duration

fun BaseStyleContext.transition(property: TransitionProperty, duration: Duration?) {
    writeStyleProperty("transition", "$property ${duration?.toCssString() ?: ""}")
}

fun BaseStyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration?
) {
    writeStyleProperty("transition",
            "$property ${duration.toCssString()} $timing ${delay?.toCssString() ?: ""}")
}

fun BaseStyleContext.transition(value: CssValue) {
    writeStyleProperty("transition", value)
}
