// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress
import kotlin.time.Duration

fun StyleContext.transition(property: TransitionProperty, duration: Duration? = null) {
    writeStyleProperty("transition",
            """$property${if (duration == null) "" else " ${duration.toCssString()}"}""")
}

fun StyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration? = null
) {
    writeStyleProperty("transition",
            """$property ${duration.toCssString()} $timing${if (delay == null) "" else " " + delay.toCssString()}""")
}

fun StyleContext.transition(value: CssValue) {
    writeStyleProperty("transition", value)
}

fun InlineStyleContext.transition(property: TransitionProperty, duration: Duration? = null) {
    writeStyleProperty("transition",
            """$property${if (duration == null) "" else " ${duration.toCssString()}"}""")
}

fun InlineStyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration? = null
) {
    writeStyleProperty("transition",
            """$property ${duration.toCssString()} $timing${if (delay == null) "" else " " + delay.toCssString()}""")
}

fun InlineStyleContext.transition(value: CssValue) {
    writeStyleProperty("transition", value)
}
