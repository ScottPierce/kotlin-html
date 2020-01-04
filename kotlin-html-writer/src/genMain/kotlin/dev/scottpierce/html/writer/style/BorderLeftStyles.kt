// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun BaseStyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun BaseStyleContext.borderLeft(value: Border) {
    writeStyleProperty("border-left", value)
}

fun StyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun StyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun StyleContext.borderLeft(value: Border) {
    writeStyleProperty("border-left", value)
}

fun InlineStyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun InlineStyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-left", """$width $style $color""")
}

fun InlineStyleContext.borderLeft(value: Border) {
    writeStyleProperty("border-left", value)
}
