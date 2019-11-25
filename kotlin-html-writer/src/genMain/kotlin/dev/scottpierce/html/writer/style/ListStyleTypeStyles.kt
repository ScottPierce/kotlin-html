// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.listStyleType(value: ListStyleType) {
    writeStyleProperty("list-style-type", value)
}

fun StyleContext.listStyleType(value: ListStyleType) {
    writeStyleProperty("list-style-type", value)
}

fun InlineStyleContext.listStyleType(value: ListStyleType) {
    writeStyleProperty("list-style-type", value)
}

enum class ListStyleType(
    val value: String
) {
    DISC("disc"),

    ARMENIAN("armenian"),

    CIRCLE("circle"),

    CJK_IDEOGRAPHIC("cjk-ideographic"),

    DECIMAL("decimal"),

    DECIMAL_LEADING_ZERO("decimal-leading-zero"),

    GEORGIAN("georgian"),

    HEBREW("hebrew"),

    HIRAGANA("hiragana"),

    HIRAGANA_IROHA("hiragana-iroha"),

    KATAKANA("katakana"),

    KATAKANA_IROHA("katakana-iroha"),

    LOWER_ALPHA("lower-alpha"),

    LOWER_GREEK("lower-greek"),

    LOWER_LATIN("lower-latin"),

    LOWER_ROMAN("lower-roman"),

    NONE("none"),

    SQUARE("square"),

    UPPER_ALPHA("upper-alpha"),

    UPPER_GREEK("upper-greek"),

    UPPER_LATIN("upper-latin"),

    UPPER_ROMAN("upper-roman"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}
