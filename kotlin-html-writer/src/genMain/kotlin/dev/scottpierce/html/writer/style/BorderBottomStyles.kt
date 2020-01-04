// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun BaseStyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun BaseStyleContext.borderBottom(value: Border) {
    writeStyleProperty("border-bottom", value)
}

fun StyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun StyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun StyleContext.borderBottom(value: Border) {
    writeStyleProperty("border-bottom", value)
}

fun InlineStyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun InlineStyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-bottom", """$width $style $color""")
}

fun InlineStyleContext.borderBottom(value: Border) {
    writeStyleProperty("border-bottom", value)
}
