// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.listStyleImage(imageUrl: String) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""")
}

fun BaseStyleContext.listStyleImage(value: ListStyleImage) {
    writeStyleProperty("list-style-image", value)
}

fun StyleContext.listStyleImage(imageUrl: String) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""")
}

fun StyleContext.listStyleImage(value: ListStyleImage) {
    writeStyleProperty("list-style-image", value)
}

fun InlineStyleContext.listStyleImage(imageUrl: String) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""")
}

fun InlineStyleContext.listStyleImage(value: ListStyleImage) {
    writeStyleProperty("list-style-image", value)
}

enum class ListStyleImage(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
