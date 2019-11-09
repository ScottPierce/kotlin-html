// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.display(value: Display) {
    writeStyleProperty("display", value)
}

fun BaseStyleContext.displayNone() {
    writeStyleProperty("display", "display: none")
}

fun BaseStyleContext.displayInline() {
    writeStyleProperty("display", "display: inline")
}

fun BaseStyleContext.displayBlock() {
    writeStyleProperty("display", "display: block")
}

fun BaseStyleContext.displayFlex() {
    writeStyleProperty("display", "display: flex")
}

fun BaseStyleContext.displayGrid() {
    writeStyleProperty("display", "display: grid")
}

enum class Display(
    val value: String
) {
    INLINE("inline"),

    BLOCK("block"),

    CONTENTS("contents"),

    FLEX("flex"),

    GRID("grid"),

    INLINE_BLOCK("inline-block"),

    INLINE_FLEX("inline-flex"),

    INLINE_GRID("inline-grid"),

    INLINE_TABLE("inline-table"),

    LIST_ITEM("list-item"),

    RUN_IN("run-in"),

    TABLE("table"),

    TABLE_CAPTION("table-caption"),

    TABLE_COLUMN_GROUP("table-column-group"),

    TABLE_HEADER_GROUP("table-header-group"),

    TABLE_FOOTER_GROUP("table-footer-group"),

    TABLE_ROW_GROUP("table-row-group"),

    TABLE_CELL("table-cell"),

    TABLE_COLUMN("table-column"),

    TABLE_ROW("table-row"),

    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
