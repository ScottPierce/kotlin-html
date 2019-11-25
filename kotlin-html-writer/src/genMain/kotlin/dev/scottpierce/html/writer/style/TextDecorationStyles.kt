// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Suppress

fun BaseStyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""")
}

fun BaseStyleContext.textDecoration(value: CssValue) {
    writeStyleProperty("text-decoration", value)
}

fun StyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""")
}

fun StyleContext.textDecoration(value: CssValue) {
    writeStyleProperty("text-decoration", value)
}

fun InlineStyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""")
}

fun InlineStyleContext.textDecoration(value: CssValue) {
    writeStyleProperty("text-decoration", value)
}
