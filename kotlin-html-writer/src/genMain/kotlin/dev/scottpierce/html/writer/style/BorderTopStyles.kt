// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Suppress

fun BaseStyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun BaseStyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun BaseStyleContext.borderTop(value: Border) {
    writeStyleProperty("border-top", value)
}

fun StyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun StyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun StyleContext.borderTop(value: Border) {
    writeStyleProperty("border-top", value)
}

fun InlineStyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun InlineStyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color
) {
    writeStyleProperty("border-top", """$width $style $color""")
}

fun InlineStyleContext.borderTop(value: Border) {
    writeStyleProperty("border-top", value)
}
