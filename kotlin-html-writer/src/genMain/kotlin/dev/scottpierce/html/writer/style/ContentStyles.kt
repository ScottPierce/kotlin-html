// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.content(value: String) {
    writeStyleProperty("content", value)
}

fun StyleContext.content(value: Content) {
    writeStyleProperty("content", value)
}

fun InlineStyleContext.content(value: String) {
    writeStyleProperty("content", value)
}

fun InlineStyleContext.content(value: Content) {
    writeStyleProperty("content", value)
}

enum class Content(
    val value: String
) {
    NORMAL("normal"),

    NONE("none"),

    COUNTER("counter"),

    ATTR("attr"),

    OPEN_QUOTE("open-quote"),

    CLOSE_QUOTE("close-quote"),

    NO_OPEN_QUOTE("no-open-quote"),

    NO_CLOSE_QUOTE("no-close-quote"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
