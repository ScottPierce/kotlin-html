package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName

@Suppress("unused")
enum class StyleProperty(
    val cssName: String,
    val type: PropertyType
) {
    BACKGROUND("background", PropertyType.COLOR),
    COLOR("color", PropertyType.COLOR),
    DISPLAY("display", PropertyType.DISPLAY),
    ALIGN_ITEMS("align-items", PropertyType.ALIGN_ITEMS),
    FLEX_DIRECTION("flex-direction", PropertyType.ALIGN_ITEMS),
    ;

    val propertyName: String = cssName.snakeCaseToCamelCase()
}

enum class PropertyType(val className: ClassName) {
    COLOR(ClassName("dev.scottpierce.html.style", "Color")),
    DISPLAY(ClassName("dev.scottpierce.html.style", "Display")),
    ALIGN_ITEMS(ClassName("dev.scottpierce.html.style", "AlignItems")),
    FLEX_DIRECTION(ClassName("dev.scottpierce.html.style", "FlexDirection")),
    ;
}