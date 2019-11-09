// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.listStylePosition(value: ListStylePosition) {
    writeStyleProperty("list-style-position", value)
}

enum class ListStylePosition(
    val value: String
) {
    INSIDE("inside"),

    OUTSIDE("outside"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}