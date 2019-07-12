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
    HEIGHT("height", PropertyType.DIMENSION),
    JUSTIFY_CONTENT("justify-content", PropertyType.JUSTIFY_CONTENT),
    OUTLINE("outline", PropertyType.STRING),
    PADDING("padding", PropertyType.DIMENSION),
    PADDING_LEFT("padding-left", PropertyType.DIMENSION),
    PADDING_RIGHT("padding-right", PropertyType.DIMENSION),
    PADDING_TOP("padding-top", PropertyType.DIMENSION),
    PADDING_BOTTOM("padding-bottom", PropertyType.DIMENSION),
    MARGIN("margin", PropertyType.DIMENSION),
    MARGIN_LEFT("margin-left", PropertyType.DIMENSION),
    MARGIN_RIGHT("margin-right", PropertyType.DIMENSION),
    MARGIN_TOP("margin-top", PropertyType.DIMENSION),
    MARGIN_BOTTOM("margin-bottom", PropertyType.DIMENSION),
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
    INT(com.squareup.kotlinpoet.INT),
    JUSTIFY_CONTENT(ClassName("dev.scottpierce.html.style", "JustifyContent")),
    STRING(com.squareup.kotlinpoet.STRING),
    ;
}