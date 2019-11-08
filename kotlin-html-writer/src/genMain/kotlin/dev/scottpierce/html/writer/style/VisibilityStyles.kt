// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.visibility(value: Visibility) {
    writeStyleProperty("visibility", value)
}

enum class Visibility(
    val value: String
) {
    VISIBLE("visible"),

    HIDDEN("hidden"),

    COLLAPSE("collapse"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
