package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.STRING

@Suppress("unused")
enum class StyleProperty(
    val cssName: String,
    val type: PropertyType
) {
    ALIGN_ITEMS("align-items", PropertyType.ALIGN_ITEMS),
    ALIGN_SELF("align-self", PropertyType.ALIGN_SELF),
    ANIMATION_NAME("animation-name", PropertyType.STRING),
    ANIMATION_DURATION("animation-duration", PropertyType.STRING),
    BACKGROUND("background", PropertyType.STRING),
    BACKGROUND_COLOR("background-color", PropertyType.COLOR),
    BORDER("border", PropertyType.STRING),
    BORDER_RADIUS("border-radius", PropertyType.DIMENSION),
    BOTTOM("bottom", PropertyType.DIMENSION),
    BOX_SHADOW("box-shadow", PropertyType.STRING),
    COLOR("color", PropertyType.COLOR),
    CONTENT("content", PropertyType.STRING),
    CURSOR("cursor", PropertyType.STRING),
    DISPLAY("display", PropertyType.DISPLAY),
    FILL("fill", PropertyType.STRING),
    FLEX("flex", PropertyType.STRING),
    FLEX_GROW("flex-grow", PropertyType.STRING),
    FLEX_SHRINK("flex-shrink", PropertyType.STRING),
    FLEX_BASIS("flex-basis", PropertyType.STRING),
    FLEX_DIRECTION("flex-direction", PropertyType.FLEX_DIRECTION),
    FLEX_WRAP("flex-wrap", PropertyType.FLEX_WRAP),
    FLOAT("float", PropertyType.FLOAT_DIRECTION),
    FONT_FAMILY("font-family", PropertyType.STRING),
    FONT_WEIGHT("font-weight", PropertyType.STRING),
    FONT_SIZE("font-size", PropertyType.DIMENSION),
    GRID_COLUMN_GAP("grid-column-gap", PropertyType.DIMENSION),
    GRID_ROW_GAP("grid-row-gap", PropertyType.DIMENSION),
    GRID_TEMPLATE_COLUMNS("grid-template-columns", PropertyType.STRING),
    GRID_TEMPLATE_ROWS("grid-template-rows", PropertyType.STRING),
    HEIGHT("height", PropertyType.DIMENSION),
    JUSTIFY_SELF("justify-self", PropertyType.JUSTIFY_SELF),
    JUSTIFY_CONTENT("justify-content", PropertyType.JUSTIFY_CONTENT),
    LEFT("left", PropertyType.DIMENSION),
    LETTER_SPACING("letter-spacing", PropertyType.DIMENSION),
    LINE_HEIGHT("line-height", PropertyType.DOUBLE),
    LIST_STYLE("list-style", PropertyType.LIST_STYLE),
    OUTLINE("outline", PropertyType.STRING),
    PADDING("padding", PropertyType.DIMENSION),
    PADDING_LEFT("padding-left", PropertyType.DIMENSION),
    PADDING_RIGHT("padding-right", PropertyType.DIMENSION),
    PADDING_TOP("padding-top", PropertyType.DIMENSION),
    PADDING_BOTTOM("padding-bottom", PropertyType.DIMENSION),
    POSITION("position", PropertyType.POSITION),
    MARGIN("margin", PropertyType.DIMENSION),
    MARGIN_BLOCK_END("margin-block-end", PropertyType.DIMENSION),
    MARGIN_BLOCK_START("margin-block-start", PropertyType.DIMENSION),
    MARGIN_BOTTOM("margin-bottom", PropertyType.DIMENSION),
    MARGIN_LEFT("margin-left", PropertyType.DIMENSION),
    MARGIN_RIGHT("margin-right", PropertyType.DIMENSION),
    MARGIN_TOP("margin-top", PropertyType.DIMENSION),
    MAX_HEIGHT("max-height", PropertyType.DIMENSION),
    MAX_WIDTH("max-width", PropertyType.DIMENSION),
    MIN_HEIGHT("min-height", PropertyType.DIMENSION),
    MIN_WIDTH("min-width", PropertyType.DIMENSION),
    OUTLINE_COLOR("outline-color", PropertyType.COLOR),
    OVERFLOW("overflow", PropertyType.STRING),
    RIGHT("right", PropertyType.DIMENSION),
    TEXT_ALIGN("text-align", PropertyType.TEXT_ALIGN),
    TEXT_DECORATION("text-decoration", PropertyType.STRING),
    TEXT_DECORATION_LINE("text-decoration-line", PropertyType.STRING),
    TEXT_TRANSFORM("text-transform", PropertyType.TEXT_TRANSFORM),
    TOP("top", PropertyType.DIMENSION),
    TRANSITION("transition", PropertyType.STRING),
    TRANSITION_PROPERTY("transition-property", PropertyType.STRING),
    VISIBILITY("visibility", PropertyType.VISIBILITY),
    WIDTH("width", PropertyType.DIMENSION),
    Z_INDEX("z-index", PropertyType.INT),
    ;

    val propertyName: String = cssName.snakeCaseToCamelCase()
}

enum class PropertyType(val className: ClassName) {
    ALIGN_ITEMS(ClassName("dev.scottpierce.html.style", "AlignItems")),
    ALIGN_SELF(ClassName("dev.scottpierce.html.style", "AlignSelf")),
    COLOR(ClassName("dev.scottpierce.html.style", "Color")),
    DIMENSION(ClassName("dev.scottpierce.html.style", "Dimension")),
    DISPLAY(ClassName("dev.scottpierce.html.style", "Display")),
    DOUBLE(com.squareup.kotlinpoet.DOUBLE),
    FLEX_DIRECTION(ClassName("dev.scottpierce.html.style", "FlexDirection")),
    FLEX_WRAP(ClassName("dev.scottpierce.html.style", "FlexWrap")),
    FLOAT_DIRECTION(ClassName("dev.scottpierce.html.style", "FloatDirection")),
    FLOAT(com.squareup.kotlinpoet.FLOAT),
    INT(com.squareup.kotlinpoet.INT),
    JUSTIFY_CONTENT(ClassName("dev.scottpierce.html.style", "JustifyContent")),
    JUSTIFY_SELF(ClassName("dev.scottpierce.html.style", "JustifySelf")),
    POSITION(ClassName("dev.scottpierce.html.style", "Position")),
    LIST_STYLE(ClassName("dev.scottpierce.html.style", "ListStyle")),
    STRING(com.squareup.kotlinpoet.STRING),
    TEXT_ALIGN(ClassName("dev.scottpierce.html.style", "TextAlign")),
    TEXT_TRANSFORM(ClassName("dev.scottpierce.html.style", "TextTransform")),
    VISIBILITY(ClassName("dev.scottpierce.html.style", "Visibility")),
    ;
}