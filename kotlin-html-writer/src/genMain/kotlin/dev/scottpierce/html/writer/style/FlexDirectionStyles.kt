// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.flexDirection(value: FlexDirection) {
    writeStyleProperty("flex-direction", value)
}

fun StyleContext.flexDirection(value: FlexDirection) {
    writeStyleProperty("flex-direction", value)
}

fun InlineStyleContext.flexDirection(value: FlexDirection) {
    writeStyleProperty("flex-direction", value)
}

enum class FlexDirection(
    val value: String
) {
    COLUMN("column"),

    COLUMN_REVERSE("column-reverse"),

    ROW_REVERSE("row-reverse"),

    ROW("row"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
