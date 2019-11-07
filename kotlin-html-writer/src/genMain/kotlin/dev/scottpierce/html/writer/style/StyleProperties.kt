// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.alignItems(value: AlignItems) {
    writeStyleProperty("align-items", value)
}

fun BaseStyleContext.alignSelf(value: AlignSelf) {
    writeStyleProperty("align-self", value)
}

fun BaseStyleContext.backgroundColor(value: Color) {
    writeStyleProperty("background-color", value)
}

fun BaseStyleContext.backgroundColor(value: String) {
    writeStyleProperty("background-color", Color.colorString(value))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int
) {
    writeStyleProperty("background-color", Color.colorString(r, g, b))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Float
) {
    writeStyleProperty("background-color", Color.colorString(r, g, b, a))
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Double
) {
    writeStyleProperty("background-color", Color.colorString(r, g, b, a))
}

fun BaseStyleContext.backgroundImage(url: String) {
    writeStyleProperty("background-image", "url('$url')")
}

fun BaseStyleContext.backgroundImage(vararg urls: String) {
    writeStyleProperty("background-image", writeBackgroundImages(urls))
}

fun BaseStyleContext.borderRadius(value: Dimension) {
    writeStyleProperty("border-radius", value)
}

fun BaseStyleContext.borderRadius(topLeftAndBottomRight: Dimension,
        topRightAndBottomLeft: Dimension) {
    writeStyleProperty("border-radius", "$topLeftAndBottomRight $topRightAndBottomLeft")
}

fun BaseStyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension
) {
    writeStyleProperty("border-radius", "$topLeft $topRightAndBottomLeft $bottomRight")
}

fun BaseStyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension
) {
    writeStyleProperty("border-radius", "$topLeft $topRight $bottomRight $bottomLeft")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Int,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Int,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Float,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Float,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Double,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Int,
    flexShrink: Double,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Int,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Int,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Float,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Float,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Double,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Float,
    flexShrink: Double,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Int,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Int,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Float,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Float,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Double,
    flexBasis: Dimension
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

fun BaseStyleContext.flex(
    flexGrow: Double,
    flexShrink: Double,
    flexBasis: FlexBasis
) {
    writeStyleProperty("flex", "$flexGrow $flexShrink $flexBasis")
}

sealed class Flex(
    val value: String
) {
    override fun toString() = value

    object Auto : Flex("auto")

    object Initial : Flex("initial")

    object Inherit : Flex("inherit")

    object None : Flex("none")
}

fun BaseStyleContext.flex(value: Flex) {
    writeStyleProperty("flex", value)
}

fun BaseStyleContext.flexBasis(value: Int) {
    writeStyleProperty("flex-basis", value)
}

fun BaseStyleContext.flexBasis(value: Float) {
    writeStyleProperty("flex-basis", value)
}

fun BaseStyleContext.flexBasis(value: Double) {
    writeStyleProperty("flex-basis", value)
}

sealed class FlexBasis(
    val value: String
) {
    override fun toString() = value

    object Auto : FlexBasis("auto")

    object Initial : FlexBasis("initial")

    object Inherit : FlexBasis("inherit")
}

fun BaseStyleContext.flexBasis(value: FlexBasis) {
    writeStyleProperty("flex-basis", value)
}

fun BaseStyleContext.flexGrow(value: Int) {
    writeStyleProperty("flex-grow", value)
}

fun BaseStyleContext.flexGrow(value: Float) {
    writeStyleProperty("flex-grow", value)
}

fun BaseStyleContext.flexGrow(value: Double) {
    writeStyleProperty("flex-grow", value)
}

fun BaseStyleContext.flexGrow(value: CssValue) {
    writeStyleProperty("flex-grow", value)
}

fun BaseStyleContext.flexShrink(value: Int) {
    writeStyleProperty("flex-shrink", value)
}

fun BaseStyleContext.flexShrink(value: Float) {
    writeStyleProperty("flex-shrink", value)
}

fun BaseStyleContext.flexShrink(value: Double) {
    writeStyleProperty("flex-shrink", value)
}

fun BaseStyleContext.flexShrink(value: CssValue) {
    writeStyleProperty("flex-shrink", value)
}

fun BaseStyleContext.flexDirection(value: FlexDirection) {
    writeStyleProperty("flex-direction", value)
}

fun BaseStyleContext.flexWrap(value: FlexWrap) {
    writeStyleProperty("flex-wrap", value)
}

fun BaseStyleContext.float(value: FloatDirection) {
    writeStyleProperty("float", value)
}

fun BaseStyleContext.fontFamily(value: String) {
    writeStyleProperty("font-family", value)
}

fun BaseStyleContext.fontFamily(value: CssValue) {
    writeStyleProperty("font-family", value)
}

fun BaseStyleContext.fontWeight(value: Int) {
    writeStyleProperty("font-weight", value)
}

sealed class FontWeight(
    val value: String
) {
    override fun toString() = value

    object Normal : FontWeight("normal")

    object Bold : FontWeight("bold")

    object Bolder : FontWeight("bolder")

    object Lighter : FontWeight("lighter")

    object Inherit : FontWeight("inherit")

    object Initial : FontWeight("initial")
}

fun BaseStyleContext.fontWeight(value: FontWeight) {
    writeStyleProperty("font-weight", value)
}

fun BaseStyleContext.fontSize(value: Dimension) {
    writeStyleProperty("font-size", value)
}

sealed class FontSize(
    val value: String
) {
    override fun toString() = value

    object XxSmall : FontSize("xx-small")

    object XSmall : FontSize("x-small")

    object Smaller : FontSize("smaller")

    object Small : FontSize("small")

    object Large : FontSize("large")

    object Larger : FontSize("larger")

    object XLarge : FontSize("x-large")

    object XxLarge : FontSize("xx-large")

    object Inherit : FontSize("inherit")

    object Initial : FontSize("initial")
}

fun BaseStyleContext.fontSize(value: FontSize) {
    writeStyleProperty("font-size", value)
}

fun BaseStyleContext.height(value: Dimension) {
    writeStyleProperty("height", value)
}

sealed class Height(
    val value: String
) {
    override fun toString() = value

    object Auto : Height("auto")

    object Initial : Height("initial")

    object Inherit : Height("inherit")
}

fun BaseStyleContext.height(value: Height) {
    writeStyleProperty("height", value)
}

fun BaseStyleContext.justifySelf(value: JustifySelf) {
    writeStyleProperty("justify-self", value)
}

fun BaseStyleContext.justifyContent(value: JustifyContent) {
    writeStyleProperty("justify-content", value)
}

fun BaseStyleContext.left(value: Dimension) {
    writeStyleProperty("left", value)
}

sealed class Left(
    val value: String
) {
    override fun toString() = value

    object Auto : Left("auto")

    object Initial : Left("initial")

    object Inherit : Left("inherit")
}

fun BaseStyleContext.left(value: Left) {
    writeStyleProperty("left", value)
}

fun BaseStyleContext.letterSpacing(value: Dimension) {
    writeStyleProperty("letter-spacing", value)
}

sealed class LetterSpacing(
    val value: String
) {
    override fun toString() = value

    object Normal : LetterSpacing("normal")

    object Initial : LetterSpacing("initial")

    object Inherit : LetterSpacing("inherit")
}

fun BaseStyleContext.letterSpacing(value: LetterSpacing) {
    writeStyleProperty("letter-spacing", value)
}

fun BaseStyleContext.lineHeight(multiplier: Int) {
    writeStyleProperty("line-height", multiplier)
}

fun BaseStyleContext.lineHeight(multiplier: Float) {
    writeStyleProperty("line-height", multiplier)
}

fun BaseStyleContext.lineHeight(multiplier: Double) {
    writeStyleProperty("line-height", multiplier)
}

fun BaseStyleContext.lineHeight(value: Dimension) {
    writeStyleProperty("line-height", value)
}

sealed class LineHeight(
    val value: String
) {
    override fun toString() = value

    object Normal : LineHeight("normal")

    object Initial : LineHeight("initial")

    object Inherit : LineHeight("inherit")
}

fun BaseStyleContext.lineHeight(value: LineHeight) {
    writeStyleProperty("line-height", value)
}
