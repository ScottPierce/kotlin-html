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
    BACKGROUND("background", PropertyType.STRING),
    BACKGROUND_COLOR("background-color", PropertyType.COLOR),
    BORDER("border", PropertyType.STRING),
    COLOR("color", PropertyType.COLOR),
    DISPLAY("display", PropertyType.DISPLAY),
    FLEX_DIRECTION("flex-direction", PropertyType.FLEX_DIRECTION),
    FLOAT("float", PropertyType.FLOAT_DIRECTION),
    FONT_FAMILY("font-family", PropertyType.STRING),
    HEIGHT("height", PropertyType.DIMENSION),
    JUSTIFY_CONTENT("justify-content", PropertyType.JUSTIFY_CONTENT),
    LIST_STYLE("list-style", PropertyType.LIST_STYLE),
    OUTLINE("outline", PropertyType.STRING),
    PADDING("padding", PropertyType.DIMENSION),
    PADDING_LEFT("padding-left", PropertyType.DIMENSION),
    PADDING_RIGHT("padding-right", PropertyType.DIMENSION),
    PADDING_TOP("padding-top", PropertyType.DIMENSION),
    PADDING_BOTTOM("padding-bottom", PropertyType.DIMENSION),
    POSITION("position", PropertyType.POSITION),
    MARGIN("margin", PropertyType.DIMENSION),
    MARGIN_LEFT("margin-left", PropertyType.DIMENSION),
    MARGIN_RIGHT("margin-right", PropertyType.DIMENSION),
    MARGIN_TOP("margin-top", PropertyType.DIMENSION),
    MARGIN_BOTTOM("margin-bottom", PropertyType.DIMENSION),
    MAX_HEIGHT("max-height", PropertyType.DIMENSION),
    MAX_WIDTH("max-width", PropertyType.DIMENSION),
    MIN_HEIGHT("min-height", PropertyType.DIMENSION),
    MIN_WIDTH("min-width", PropertyType.DIMENSION),
    TEXT_DECORATION("text-decoration", PropertyType.STRING),
    TEXT_TRANSFORM("text-transform", PropertyType.TEXT_TRANSFORM),
    WIDTH("width", PropertyType.DIMENSION),
    Z_INDEX("z-index", PropertyType.INT),
    ;

    val propertyName: String = cssName.snakeCaseToCamelCase()
}

enum class PropertyType(val className: ClassName) {
    ALIGN_ITEMS(ClassName("dev.scottpierce.html.style", "AlignItems")),
    COLOR(ClassName("dev.scottpierce.html.style", "Color")),
    DIMENSION(ClassName("dev.scottpierce.html.style", "Dimension")),
    DISPLAY(ClassName("dev.scottpierce.html.style", "Display")),
    FLEX_DIRECTION(ClassName("dev.scottpierce.html.style", "FlexDirection")),
    FLOAT_DIRECTION(ClassName("dev.scottpierce.html.style", "FloatDirection")),
    INT(com.squareup.kotlinpoet.INT),
    JUSTIFY_CONTENT(ClassName("dev.scottpierce.html.style", "JustifyContent")),
    POSITION(ClassName("dev.scottpierce.html.style", "Position")),
    LIST_STYLE(ClassName("dev.scottpierce.html.style", "ListStyle")),
    STRING(com.squareup.kotlinpoet.STRING),
    TEXT_TRANSFORM(ClassName("dev.scottpierce.html.style", "TextTransform")),
    ;
}