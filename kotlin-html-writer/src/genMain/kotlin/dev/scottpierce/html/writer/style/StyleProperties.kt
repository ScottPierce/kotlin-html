// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.Deprecated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.UnsupportedOperationException
import kotlin.jvm.JvmSynthetic

var BaseStyleContext.alignItems: AlignItems
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("align-items", value.toString())
    }

var BaseStyleContext.alignSelf: AlignSelf
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("align-self", value.toString())
    }

var BaseStyleContext.animationName: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("animation-name", value)
    }

var BaseStyleContext.animationDuration: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("animation-duration", value)
    }

var BaseStyleContext.background: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("background", value)
    }

var BaseStyleContext.backgroundColor: Color
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("background-color", value.toString())
    }

var BaseStyleContext.border: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("border", value)
    }

var BaseStyleContext.borderRadius: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("border-radius", value.toString())
    }

var BaseStyleContext.bottom: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("bottom", value.toString())
    }

var BaseStyleContext.boxShadow: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("box-shadow", value)
    }

var BaseStyleContext.color: Color
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("color", value.toString())
    }

var BaseStyleContext.content: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("content", value)
    }

var BaseStyleContext.cursor: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("cursor", value)
    }

var BaseStyleContext.display: Display
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("display", value.toString())
    }

var BaseStyleContext.fill: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("fill", value)
    }

var BaseStyleContext.flex: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("flex", value)
    }

var BaseStyleContext.flexGrow: Double
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        val v = when (value) {
            Double.POSITIVE_INFINITY -> "initial"
            Double.NEGATIVE_INFINITY -> "inherit"
            else -> value.toString()
        }
        writeStyleProperty("flex-grow", v)
    }

object FlexGrow {
    val INITIAL: Double
        get() = Double.POSITIVE_INFINITY

    val INHERIT: Double
        get() = Double.NEGATIVE_INFINITY
}

var BaseStyleContext.flexShrink: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("flex-shrink", value)
    }

var BaseStyleContext.flexBasis: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("flex-basis", value)
    }

var BaseStyleContext.flexDirection: FlexDirection
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("flex-direction", value.toString())
    }

var BaseStyleContext.flexWrap: FlexWrap
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("flex-wrap", value.toString())
    }

var BaseStyleContext.float: FloatDirection
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("float", value.toString())
    }

var BaseStyleContext.fontFamily: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("font-family", value)
    }

var BaseStyleContext.fontWeight: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("font-weight", value)
    }

var BaseStyleContext.fontSize: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("font-size", value.toString())
    }

var BaseStyleContext.gridColumnGap: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("grid-column-gap", value.toString())
    }

var BaseStyleContext.gridRowGap: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("grid-row-gap", value.toString())
    }

var BaseStyleContext.gridTemplateColumns: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("grid-template-columns", value)
    }

var BaseStyleContext.gridTemplateRows: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("grid-template-rows", value)
    }

var BaseStyleContext.height: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("height", value.toString())
    }

var BaseStyleContext.justifySelf: JustifySelf
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("justify-self", value.toString())
    }

var BaseStyleContext.justifyContent: JustifyContent
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("justify-content", value.toString())
    }

var BaseStyleContext.left: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("left", value.toString())
    }

var BaseStyleContext.letterSpacing: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("letter-spacing", value.toString())
    }

var BaseStyleContext.lineHeight: LineHeight
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("line-height", value.toString())
    }

var BaseStyleContext.listStyle: ListStyle
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("list-style", value.toString())
    }

var BaseStyleContext.outline: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("outline", value)
    }

var BaseStyleContext.padding: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("padding", value.toString())
    }

var BaseStyleContext.paddingLeft: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("padding-left", value.toString())
    }

var BaseStyleContext.paddingRight: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("padding-right", value.toString())
    }

var BaseStyleContext.paddingTop: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("padding-top", value.toString())
    }

var BaseStyleContext.paddingBottom: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("padding-bottom", value.toString())
    }

var BaseStyleContext.position: Position
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("position", value.toString())
    }

var BaseStyleContext.margin: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin", value.toString())
    }

var BaseStyleContext.marginBlockEnd: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-block-end", value.toString())
    }

var BaseStyleContext.marginBlockStart: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-block-start", value.toString())
    }

var BaseStyleContext.marginBottom: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-bottom", value.toString())
    }

var BaseStyleContext.marginLeft: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-left", value.toString())
    }

var BaseStyleContext.marginRight: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-right", value.toString())
    }

var BaseStyleContext.marginTop: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("margin-top", value.toString())
    }

var BaseStyleContext.maxHeight: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("max-height", value.toString())
    }

var BaseStyleContext.maxWidth: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("max-width", value.toString())
    }

var BaseStyleContext.minHeight: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("min-height", value.toString())
    }

var BaseStyleContext.minWidth: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("min-width", value.toString())
    }

var BaseStyleContext.outlineColor: Color
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("outline-color", value.toString())
    }

var BaseStyleContext.overflow: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("overflow", value)
    }

var BaseStyleContext.right: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("right", value.toString())
    }

var BaseStyleContext.textAlign: TextAlign
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("text-align", value.toString())
    }

var BaseStyleContext.textDecoration: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("text-decoration", value)
    }

var BaseStyleContext.textDecorationLine: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("text-decoration-line", value)
    }

var BaseStyleContext.textTransform: TextTransform
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("text-transform", value.toString())
    }

var BaseStyleContext.top: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("top", value.toString())
    }

var BaseStyleContext.transition: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("transition", value)
    }

var BaseStyleContext.transitionProperty: String
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("transition-property", value)
    }

var BaseStyleContext.visibility: Visibility
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("visibility", value.toString())
    }

var BaseStyleContext.width: Dimension
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("width", value.toString())
    }

var BaseStyleContext.zIndex: Int
    @JvmSynthetic
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        writeStyleProperty("z-index", value.toString())
    }
