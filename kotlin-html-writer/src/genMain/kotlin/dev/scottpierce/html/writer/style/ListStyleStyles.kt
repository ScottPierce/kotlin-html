// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String
) {
    writeStyleProperty("list-style", "$type $position url('$imageUrl')")
}

fun BaseStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage
) {
    writeStyleProperty("list-style", "$type $position $image")
}

fun BaseStyleContext.listStyle(value: CssValue) {
    writeStyleProperty("list-style", value)
}
