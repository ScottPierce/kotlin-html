// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.transitionProperty(value: TransitionProperty) {
    writeStyleProperty("transition-property", value)
}

fun BaseStyleContext.transitionProperty(vararg transitionProperties: TransitionProperty) {
    writeStyleProperty("transition-property", transitionProperties.joinToString(separator = ","))
}

fun StyleContext.transitionProperty(value: TransitionProperty) {
    writeStyleProperty("transition-property", value)
}

fun StyleContext.transitionProperty(vararg transitionProperties: TransitionProperty) {
    writeStyleProperty("transition-property", transitionProperties.joinToString(separator = ","))
}

fun InlineStyleContext.transitionProperty(value: TransitionProperty) {
    writeStyleProperty("transition-property", value)
}

fun InlineStyleContext.transitionProperty(vararg transitionProperties: TransitionProperty) {
    writeStyleProperty("transition-property", transitionProperties.joinToString(separator = ","))
}

enum class TransitionProperty(
    val value: String
) {
    NONE("none"),

    ALL("all"),

    INITIAL("initial"),

    INHERIT("inherit"),

    ALIGN_ITEMS("align-items"),

    ALIGN_SELF("align-self"),

    ANIMATION_NAME("animation-name"),

    ANIMATION_DURATION("animation-duration"),

    BACKGROUND("background"),

    BACKGROUND_ATTACHMENT("background-attachment"),

    BACKGROUND_CLIP("background-clip"),

    BACKGROUND_COLOR("background-color"),

    BACKGROUND_IMAGE("background-image"),

    BACKGROUND_ORIGIN("background-origin"),

    BACKGROUND_POSITION("background-position"),

    BACKGROUND_REPEAT("background-repeat"),

    BACKGROUND_SIZE("background-size"),

    BORDER("border"),

    BORDER_BOTTOM("border-bottom"),

    BORDER_LEFT("border-left"),

    BORDER_RIGHT("border-right"),

    BORDER_TOP("border-top"),

    BORDER_RADIUS("border-radius"),

    BORDER_STYLE("border-style"),

    BORDER_WIDTH("border-width"),

    BOTTOM("bottom"),

    BOX_SHADOW("box-shadow"),

    COLOR("color"),

    CONTENT("content"),

    CURSOR("cursor"),

    DISPLAY("display"),

    FILL("fill"),

    FLEX("flex"),

    FLEX_BASIS("flex-basis"),

    FLEX_GROW("flex-grow"),

    FLEX_SHRINK("flex-shrink"),

    FLEX_DIRECTION("flex-direction"),

    FLEX_WRAP("flex-wrap"),

    FLOAT("float"),

    FONT_FAMILY("font-family"),

    FONT_WEIGHT("font-weight"),

    FONT_SIZE("font-size"),

    HEIGHT("height"),

    JUSTIFY_CONTENT("justify-content"),

    LEFT("left"),

    LETTER_SPACING("letter-spacing"),

    LINE_HEIGHT("line-height"),

    LIST_STYLE("list-style"),

    LIST_STYLE_IMAGE("list-style-image"),

    LIST_STYLE_POSITION("list-style-position"),

    LIST_STYLE_TYPE("list-style-type"),

    MARGIN("margin"),

    MARGIN_LEFT("margin-left"),

    MARGIN_RIGHT("margin-right"),

    MARGIN_TOP("margin-top"),

    MARGIN_BOTTOM("margin-bottom"),

    MAX_HEIGHT("max-height"),

    MAX_WIDTH("max-width"),

    MIN_HEIGHT("min-height"),

    MIN_WIDTH("min-width"),

    OUTLINE("outline"),

    OUTLINE_COLOR("outline-color"),

    OUTLINE_OFFSET("outline-offset"),

    OUTLINE_STYLE("outline-style"),

    OUTLINE_WIDTH("outline-width"),

    OVERFLOW("overflow"),

    OVERFLOW_X("overflow-x"),

    OVERFLOW_Y("overflow-y"),

    PADDING("padding"),

    PADDING_LEFT("padding-left"),

    PADDING_RIGHT("padding-right"),

    PADDING_TOP("padding-top"),

    PADDING_BOTTOM("padding-bottom"),

    POSITION("position"),

    RIGHT("right"),

    TEXT_ALIGN("text-align"),

    TEXT_DECORATION("text-decoration"),

    TEXT_DECORATION_COLOR("text-decoration-color"),

    TEXT_DECORATION_LINE("text-decoration-line"),

    TEXT_DECORATION_STYLE("text-decoration-style"),

    TEXT_TRANSFORM("text-transform"),

    TOP("top"),

    TRANSITION("transition"),

    TRANSITION_PROPERTY("transition-property"),

    TRANSITION_TIMING_FUNCTION("transition-timing-function"),

    VISIBILITY("visibility"),

    WIDTH("width"),

    Z_INDEX("z-index");

    override fun toString() = value
}
