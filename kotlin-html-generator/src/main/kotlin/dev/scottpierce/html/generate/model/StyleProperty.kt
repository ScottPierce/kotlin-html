package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName

enum class StyleProperty(
    val propertyName: String,
    val type: PropertyType
) {
    BACKGROUND("background", PropertyType.COLOR),
    COLOR("color", PropertyType.COLOR),
    DISPLAY("display", PropertyType.DISPLAY),
    ;
}

enum class PropertyType(val className: ClassName) {
    COLOR(ClassName("dev.scottpierce.html.style", "Color")),
    DISPLAY(ClassName("dev.scottpierce.html.style", "Display")),
    ;
}