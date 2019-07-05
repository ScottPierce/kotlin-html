package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName

@Suppress("unused")
enum class StyleProperty(
    val cssName: String,
    val type: PropertyType
) {
    ALIGN_ITEMS("align-items", PropertyType.ALIGN_ITEMS),
    BACKGROUND("background", PropertyType.COLOR),
    COLOR("color", PropertyType.COLOR),
    DISPLAY("display", PropertyType.DISPLAY),
    FLEX_DIRECTION("flex-direction", PropertyType.FLEX_DIRECTION),
    JUSTIFY_CONTENT("justify-content", PropertyType.JUSTIFY_CONTENT),
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
    ;

    val propertyName: String = cssName.snakeCaseToCamelCase()
}

enum class PropertyType(val className: ClassName) {
    ALIGN_ITEMS(ClassName("dev.scottpierce.html.style", "AlignItems")),
    COLOR(ClassName("dev.scottpierce.html.style", "Color")),
    DIMENSION(ClassName("dev.scottpierce.html.style", "Dimension")),
    DISPLAY(ClassName("dev.scottpierce.html.style", "Display")),
    FLEX_DIRECTION(ClassName("dev.scottpierce.html.style", "FlexDirection")),
    JUSTIFY_CONTENT(ClassName("dev.scottpierce.html.style", "JustifyContent")),
    ;
}