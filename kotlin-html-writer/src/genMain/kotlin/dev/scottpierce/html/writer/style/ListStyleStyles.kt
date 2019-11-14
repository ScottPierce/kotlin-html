// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun StyleContext.listStyle(type: ListStyleType, position: ListStylePosition? = null) {
    writeStyleProperty("list-style", """$type${if (position == null) "" else " $position"}""")
}

fun StyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String
) {
    writeStyleProperty("list-style", """$type $position url('$imageUrl')""")
}

fun StyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage
) {
    writeStyleProperty("list-style", """$type $position $image""")
}

fun StyleContext.listStyle(value: CssValue) {
    writeStyleProperty("list-style", value)
}

fun InlineStyleContext.listStyle(type: ListStyleType, position: ListStylePosition? = null) {
    writeStyleProperty("list-style", """$type${if (position == null) "" else " $position"}""")
}

fun InlineStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String
) {
    writeStyleProperty("list-style", """$type $position url('$imageUrl')""")
}

fun InlineStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage
) {
    writeStyleProperty("list-style", """$type $position $image""")
}

fun InlineStyleContext.listStyle(value: CssValue) {
    writeStyleProperty("list-style", value)
}
