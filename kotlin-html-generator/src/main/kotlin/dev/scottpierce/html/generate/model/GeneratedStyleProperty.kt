package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName

@Suppress("unused")
enum class GeneratedStyleProperty(
    val cssName: String,
    val setters: List<Setter>
) {
    ALIGN_ITEMS("align-items", Setter(Parameter(styleClassName("AlignItems")))),
    ALIGN_SELF("align-self", Setter(Parameter(styleClassName( "AlignSelf")))),
    //    ANIMATION_NAME("animation-name", PropertyType.STRING),
//    ANIMATION_DURATION("animation-duration", PropertyType.STRING),
//    BACKGROUND("background", PropertyType.STRING),
    BACKGROUND_COLOR(
        cssName = "background-color",
        setters = listOf(
            Setter(Parameter(COLOR)),
            Setter("Color.colorString($0)", Parameter(STRING)),
            Setter(
                "Color.colorString($0, $1, $2)",
                Parameter(INT, name = "r"),
                Parameter(INT, name = "g"),
                Parameter(INT, name = "b")
            ),
            Setter(
                "Color.colorString($0, $1, $2, $3)",
                Parameter(INT, name = "r"),
                Parameter(INT, name = "g"),
                Parameter(INT, name = "b"),
                Parameter(com.squareup.kotlinpoet.FLOAT, name = "a")
            ),
            Setter(
                "Color.colorString($0, $1, $2, $3)",
                Parameter(INT, name = "r"),
                Parameter(INT, name = "g"),
                Parameter(INT, name = "b"),
                Parameter(DOUBLE, name = "a")
            )
        )
    ),
    BACKGROUND_IMAGE(
        "background-image",
        setters = listOf(
            Setter(
                "\"url('\$url')\"",
                Parameter(STRING, "url")
            ),
            Setter("writeBackgroundImages(urls)",
                Parameter(STRING, isVararg = true, name = "urls")
            )
        )
    ),
    BORDER_RADIUS(
        cssName = "border-radius",
        setters = listOf(
            Setter("$0", Parameter(DIMENSION)),
            Setter(
                "\"$$0 $$1\"",
                Parameter(DIMENSION, "topLeftAndBottomRight"),
                Parameter(DIMENSION, "topRightAndBottomLeft")
            ),
            Setter(
                "\"$$0 $$1 $$2\"",
                Parameter(DIMENSION, "topLeft"),
                Parameter(DIMENSION, "topRightAndBottomLeft"),
                Parameter(DIMENSION, "bottomRight")
            ),
            Setter(
                "\"$$0 $$1 $$2 $$3\"",
                Parameter(DIMENSION, "topLeft"),
                Parameter(DIMENSION, "topRight"),
                Parameter(DIMENSION, "bottomRight"),
                Parameter(DIMENSION, "bottomLeft")
            )
        )
    ),
    //    BORDER("border", PropertyType.STRING),
//    BOTTOM("bottom", PropertyType.DIMENSION),
//    BOX_SHADOW("box-shadow", PropertyType.STRING),
//    COLOR("color", PropertyType.COLOR),
//    CONTENT("content", PropertyType.STRING),
//    CURSOR("cursor", PropertyType.STRING),
//    DISPLAY("display", PropertyType.DISPLAY),
//    FILL("fill", PropertyType.STRING),
    FLEX(
        cssName = "flex",
        setters = run {
            val template = "\"$0 $1 $2\""

            val setters = mutableListOf<Setter>()

            for (param1: ClassName in listOf(INT, com.squareup.kotlinpoet.FLOAT, DOUBLE)) {
                for (param2: ClassName in listOf(INT, com.squareup.kotlinpoet.FLOAT, DOUBLE)) {
                    for (param3: ClassName in listOf(DIMENSION, dev.scottpierce.html.generate.model.FLEX_BASIS))
                        setters += Setter(
                            isStringTemplate = true,
                            template = template,
                            parameters = listOf(
                                Parameter(param1, name = "flexGrow"),
                                Parameter(param2, name = "flexShrink"),
                                Parameter(param3, name = "flexBasis")
                            )
                        )
                }
            }

            setters += Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit", "none")))

            setters
        }
    ),
    FLEX_BASIS(
        cssName = "flex-basis",
        setters = listOf(
            Setter(Parameter(INT)),
            Setter(Parameter(com.squareup.kotlinpoet.FLOAT)),
            Setter(Parameter(DOUBLE)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    FLEX_GROW(
        cssName = "flex-grow",
        setters = listOf(
            Setter(Parameter(INT)),
            Setter(Parameter(com.squareup.kotlinpoet.FLOAT)),
            Setter(Parameter(DOUBLE)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    FLEX_SHRINK(
        cssName = "flex-shrink",
        setters = listOf(
            Setter(Parameter(INT)),
            Setter(Parameter(com.squareup.kotlinpoet.FLOAT)),
            Setter(Parameter(DOUBLE)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    FLEX_DIRECTION(
        "flex-direction",
        Setter(Parameter(styleClassName("FlexDirection")))
    ),
    FLEX_WRAP(
        "flex-wrap",
        Setter(Parameter(styleClassName("FlexWrap")))
    ),
    FLOAT(
        "float",
        Setter(Parameter(styleClassName("FloatDirection")))
    ),
    FONT_FAMILY(
        cssName = "font-family",
        setters = listOf(
            Setter(Parameter(STRING)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    FONT_WEIGHT(
        cssName = "font-weight",
        setters = listOf(
            Setter(Parameter(INT)),
            Setter(Parameter(ParameterType.Generate(
                "normal",
                "bold",
                "bolder",
                "lighter",
                "inherit",
                "initial"
            )))
        )
    ),
    FONT_SIZE(
        cssName = "font-size",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate(
                "xx-small",
                "x-small",
                "smaller",
                "small",
                "large",
                "larger",
                "x-large",
                "xx-large",
                "inherit",
                "initial"
            )))
        )
    ),
    //    GRID_COLUMN_GAP("grid-column-gap", PropertyType.DIMENSION),
//    GRID_ROW_GAP("grid-row-gap", PropertyType.DIMENSION),
//    GRID_TEMPLATE_COLUMNS("grid-template-columns", PropertyType.STRING),
//    GRID_TEMPLATE_ROWS("grid-template-rows", PropertyType.STRING),
    HEIGHT(
        cssName = "height",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    JUSTIFY_SELF("justify-self", Setter(Parameter(styleClassName("JustifySelf")))),
    JUSTIFY_CONTENT("justify-content", Setter(Parameter(styleClassName("JustifyContent")))),
    LEFT(
        cssName = "left",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    LETTER_SPACING(
        cssName = "letter-spacing",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("normal", "initial", "inherit")))
        )
    ),
    LINE_HEIGHT(
        cssName = "line-height",
        setters = listOf(
            Setter(Parameter(INT, "multiplier")),
            Setter(Parameter(com.squareup.kotlinpoet.FLOAT, "multiplier")),
            Setter(Parameter(DOUBLE, "multiplier")),
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("normal", "initial", "inherit")))
        )
    )
//    LINE_HEIGHT("line-height", PropertyType.LINE_HEIGHT),
//    LIST_STYLE("list-style", PropertyType.LIST_STYLE),
//    OUTLINE("outline", PropertyType.STRING),
//    PADDING("padding", PropertyType.DIMENSION),
//    PADDING_LEFT("padding-left", PropertyType.DIMENSION),
//    PADDING_RIGHT("padding-right", PropertyType.DIMENSION),
//    PADDING_TOP("padding-top", PropertyType.DIMENSION),
//    PADDING_BOTTOM("padding-bottom", PropertyType.DIMENSION),
//    POSITION("position", PropertyType.POSITION),
//    MARGIN("margin", PropertyType.DIMENSION),
//    MARGIN_BLOCK_END("margin-block-end", PropertyType.DIMENSION),
//    MARGIN_BLOCK_START("margin-block-start", PropertyType.DIMENSION),
//    MARGIN_BOTTOM("margin-bottom", PropertyType.DIMENSION),
//    MARGIN_LEFT("margin-left", PropertyType.DIMENSION),
//    MARGIN_RIGHT("margin-right", PropertyType.DIMENSION),
//    MARGIN_TOP("margin-top", PropertyType.DIMENSION),
//    MAX_HEIGHT("max-height", PropertyType.DIMENSION),
//    MAX_WIDTH("max-width", PropertyType.DIMENSION),
//    MIN_HEIGHT("min-height", PropertyType.DIMENSION),
//    MIN_WIDTH("min-width", PropertyType.DIMENSION),
//    OUTLINE_COLOR("outline-color", PropertyType.COLOR),
//    OVERFLOW("overflow", PropertyType.STRING),
//    RIGHT("right", PropertyType.DIMENSION),
//    TEXT_ALIGN("text-align", PropertyType.TEXT_ALIGN),
//    TEXT_DECORATION("text-decoration", PropertyType.STRING),
//    TEXT_DECORATION_LINE("text-decoration-line", PropertyType.STRING),
//    TEXT_TRANSFORM("text-transform", PropertyType.TEXT_TRANSFORM),
//    TOP("top", PropertyType.DIMENSION),
//    TRANSITION("transition", PropertyType.STRING),
//    TRANSITION_PROPERTY("transition-property", PropertyType.STRING),
//    VISIBILITY("visibility", PropertyType.VISIBILITY),
//    WIDTH("width", PropertyType.DIMENSION),
//    Z_INDEX("z-index", PropertyType.INT),
    ;

    constructor(cssName: String, setter: Setter) : this(cssName, listOf(setter))
    constructor(cssName: String, vararg setters: Setter) : this(cssName, setters.toList())

    val propertyName: String = cssName.snakeCaseToCamelCase()
}

data class Setter(
    val template: String,
    val parameters: List<Parameter>,
    val isStringTemplate: Boolean = false
) {
    constructor(parameter: Parameter) : this(template = "$0", parameters = listOf(parameter))

    constructor(
        writeTemplate: String,
        vararg parameters: Parameter
    ) : this(
        template = writeTemplate,
        parameters = parameters.toList()
    )
}

data class Parameter(
    val type: ParameterType,
    val name: String = "value",
    val isVararg: Boolean = false
) {
    constructor(
        type: TypeName,
        name: String = "value",
        isVararg: Boolean = false
    ) : this(ParameterType.Exists(type), name, isVararg)
}

sealed class ParameterType {
    class Exists(val type: TypeName) : ParameterType()

    /** Represents a type that doesn't exist yet and needs to be generated */
    class Generate(val values: List<String>) : ParameterType() {
        constructor(vararg values: String) : this(values.toList())
    }
}
