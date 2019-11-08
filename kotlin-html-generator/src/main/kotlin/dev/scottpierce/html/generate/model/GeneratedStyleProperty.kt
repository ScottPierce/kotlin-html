package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.NUMBER
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName

@Suppress("unused")
enum class GeneratedStyleProperty(
    val cssName: String,
    val setters: List<Setter>
) {
    ALIGN_ITEMS("align-items", Setter(Parameter(styleClassName("AlignItems")))),
    ALIGN_SELF("align-self", Setter(Parameter(styleClassName("AlignSelf")))),
    ANIMATION_NAME(
        cssName = "animation-name",
        setters = listOf(
            Setter(Parameter(STRING)),
            Setter(Parameter(ParameterType.Generate("none", "initial", "inherit")))
        )
    ),
    ANIMATION_DURATION(
        "animation-duration",
        listOf(
            Setter(Parameter(STRING)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    //    BACKGROUND("background", PropertyType.STRING),
    BACKGROUND_COLOR("background-color", COLOR_SETTERS),
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
    BORDER(
        cssName = "border",
        setters = run {
            val setters = mutableListOf<Setter>()

            for (param1: ClassName in listOf(DIMENSION, styleClassName("BorderWidth"))) {
                setters += Setter(
                    template = "\"$$0 $$1 $$2\"",
                    parameters = listOf(
                        Parameter(param1, name = "width"),
                        Parameter(styleClassName("BorderStyle"), name = "style"),
                        Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color")
                    )
                )
            }

            setters += Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit", "none")))

            setters
        }
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
    BORDER_STYLE(
        cssName = "border-style",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "none", "hidden", "dotted", "dashed", "solid", "double", "groove", "ridge", "inset", "outset",
                "initial", "inherit"
            )))
        )
    ),
    BORDER_WIDTH(
        cssName = "border-width",
        setters = listOf(
            Setter("$0", Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("medium", "thin", "thick", "initial", "inherit")))
        )
    ),
    BOTTOM(
        cssName = "bottom",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    BOX_SHADOW(
        cssName = "box-shadow",
        setters = listOf(
            Setter(Parameter(styleClassName("BoxShadow"), name = "boxShadow")),
            Setter("writeBoxShadows(boxShadows)",
                Parameter(styleClassName("BoxShadow"), isVararg = true, name = "boxShadows")
            ),
            Setter(
                template = "BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color, inset = inset)",
                parameters = listOf(
                    Parameter(NUMBER, name = "hOffset"),
                    Parameter(NUMBER, name = "vOffset"),
                    Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color"),
                    Parameter(BOOLEAN, name = "inset", defaultValue = "false")
                )
            ),
            Setter(
                template = "BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color, blur = blur, " +
                        "spread = spread, inset = inset)",
                parameters = listOf(
                    Parameter(NUMBER, name = "hOffset"),
                    Parameter(NUMBER, name = "vOffset"),
                    Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color"),
                    Parameter(NUMBER, name = "blur"),
                    Parameter(NUMBER.copy(nullable = true), name = "spread", defaultValue = "null"),
                    Parameter(BOOLEAN, name = "inset", defaultValue = "false")
                )
            )
        )
    ),
    COLOR("color", COLOR_SETTERS),
    CONTENT(
        cssName = "content",
        setters = listOf(
            Setter(Parameter(STRING)),
            Setter(Parameter(ParameterType.Generate(
                "normal", "none", "counter", "attr", "open-quote", "close-quote", "no-open-quote", "no-close-quote",
                "initial", "inherit"
            )))
        )
    ),
    CURSOR(
        cssName = "cursor",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "alias", "all-scroll", "auto", "cell", "context-menu", "col-resize", "copy", "crosshair", "default",
                "e-resize", "ew-resize", "grab", "grabbing", "help", "move", "n-resize", "ne-resize", "nesw-resize",
                "ns-resize", "nw-resize", "nwse-resize", "no-drop", "none", "not-allowed", "pointer", "progress",
                "row-resize", "s-resize", "se-resize", "sw-resize", "text", "vertical-text", "w-resize", "wait",
                "zoom-in", "zoom-out", "initial", "inherit"
            )))
        )
    ),
    DISPLAY(
        cssName = "display",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "inline", "block", "contents", "flex", "grid", "inline-block", "inline-flex", "inline-grid",
                "inline-table", "list-item", "run-in", "table", "table-caption", "table-column-group",
                "table-header-group", "table-footer-group", "table-row-group", "table-cell", "table-column",
                "table-row", "none", "initial", "inherit"
            ))),
            Setter(
                template = "\"display: none\"",
                functionName = "displayNone",
                parameters = listOf()
            ),
            Setter(
                template = "\"display: inline\"",
                functionName = "displayInline",
                parameters = listOf()
            ),
            Setter(
                template = "\"display: block\"",
                functionName = "displayBlock",
                parameters = listOf()
            ),
            Setter(
                template = "\"display: flex\"",
                functionName = "displayFlex",
                parameters = listOf()
            ),
            Setter(
                template = "\"display: grid\"",
                functionName = "displayGrid",
                parameters = listOf()
            )
        )
    ),
    FILL("fill", COLOR_SETTERS),
    FLEX(
        cssName = "flex",
        setters = run {
            val template = "\"$$0 $$1 $$2\""

            val setters = mutableListOf<Setter>()

            for (param1: ClassName in listOf(NUMBER)) {
                for (param2: ClassName in listOf(NUMBER)) {
                    for (param3: ClassName in listOf(DIMENSION, dev.scottpierce.html.generate.model.FLEX_BASIS)) {
                        setters += Setter(
                            template = template,
                            parameters = listOf(
                                Parameter(param1, name = "flexGrow"),
                                Parameter(param2, name = "flexShrink"),
                                Parameter(param3, name = "flexBasis")
                            )
                        )
                    }
                }
            }

            setters += Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit", "none")))

            setters
        }
    ),
    FLEX_BASIS(
        cssName = "flex-basis",
        setters = listOf(
            Setter(Parameter(NUMBER)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    FLEX_GROW(
        cssName = "flex-grow",
        setters = listOf(
            Setter(Parameter(NUMBER)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    FLEX_SHRINK(
        cssName = "flex-shrink",
        setters = listOf(
            Setter(Parameter(NUMBER)),
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
            Setter(Parameter(NUMBER, "multiplier")),
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("normal", "initial", "inherit")))
        )
    ),
    MARGIN(
        cssName = "margin",
        setters = listOf(
            Setter("$0", Parameter(DIMENSION)),
            Setter(
                "\"$$0 $$1\"",
                Parameter(DIMENSION, "y"),
                Parameter(DIMENSION, "x")
            ),
            Setter(
                "\"$$0 $$1 $$2\"",
                Parameter(DIMENSION, "top"),
                Parameter(DIMENSION, "x"),
                Parameter(DIMENSION, "bottom")
            ),
            Setter(
                "\"$$0 $$1 $$2 $$3\"",
                Parameter(DIMENSION, "top"),
                Parameter(DIMENSION, "right"),
                Parameter(DIMENSION, "bottom"),
                Parameter(DIMENSION, "left")
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MARGIN_LEFT(
        cssName = "margin-left",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MARGIN_RIGHT(
        cssName = "margin-right",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MARGIN_TOP(
        cssName = "margin-top",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MARGIN_BOTTOM(
        cssName = "margin-bottom",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MAX_HEIGHT(
        cssName = "max-height",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("none", "initial", "inherit")))
        )
    ),
    MAX_WIDTH(
        cssName = "max-width",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("none", "initial", "inherit")))
        )
    ),
    MIN_HEIGHT(
        cssName = "min-height",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    MIN_WIDTH(
        cssName = "min-width",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    //    LIST_STYLE("list-style", PropertyType.LIST_STYLE),
//    OUTLINE("outline", PropertyType.STRING),
    PADDING(
        cssName = "padding",
        setters = listOf(
            Setter("$0", Parameter(DIMENSION)),
            Setter(
                "\"$$0 $$1\"",
                Parameter(DIMENSION, "y"),
                Parameter(DIMENSION, "x")
            ),
            Setter(
                "\"$$0 $$1 $$2\"",
                Parameter(DIMENSION, "top"),
                Parameter(DIMENSION, "x"),
                Parameter(DIMENSION, "bottom")
            ),
            Setter(
                "\"$$0 $$1 $$2 $$3\"",
                Parameter(DIMENSION, "top"),
                Parameter(DIMENSION, "right"),
                Parameter(DIMENSION, "bottom"),
                Parameter(DIMENSION, "left")
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    PADDING_LEFT(
        cssName = "padding-left",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    PADDING_RIGHT(
        cssName = "padding-right",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    PADDING_TOP(
        cssName = "padding-top",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    PADDING_BOTTOM(
        cssName = "padding-bottom",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    POSITION(
        cssName = "position",
        setters = listOf(
            Setter(Parameter(styleClassName("Position")))
        )
    ),
    OUTLINE_COLOR("outline-color", COLOR_SETTERS),
    OVERFLOW(
        cssName = "overflow",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("visible", "hidden", "scroll", "auto", "initial", "inherit")))
        )
    ),
    OVERFLOW_X(
        cssName = "overflow-x",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(styleClassName("Overflow")))
        )
    ),
    OVERFLOW_Y(
        cssName = "overflow-y",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(styleClassName("Overflow")))
        )
    ),
    RIGHT(
        cssName = "right",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    TEXT_ALIGN(
        cssName = "text-align",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate("left", "right", "center", "justify", "initial", "inherit")))
        )
    ),
    //    TEXT_DECORATION("text-decoration", PropertyType.STRING),
    TEXT_DECORATION_LINE(
        cssName = "text-decoration-line",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate("none", "underline", "overline", "line-through", "initial", "inherit")))
        )
    ),
    TEXT_TRANSFORM(
        cssName = "text-transform",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate("none", "capitalize", "uppercase", "lowercase", "initial", "inherit")))
        )
    ),
    TOP(
        cssName = "top",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    //    TRANSITION("transition", PropertyType.STRING),
//    TRANSITION_PROPERTY("transition-property", PropertyType.STRING),
    VISIBILITY(
        cssName = "visibility",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate("visible", "hidden", "collapse", "initial", "inherit")))
        )
    ),
    WIDTH(
        cssName = "width",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    Z_INDEX(
        cssName = "z-index",
        setters = listOf(
            Setter(Parameter(INT)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    ;

    constructor(cssName: String, setter: Setter) : this(cssName, listOf(setter))
    constructor(cssName: String, vararg setters: Setter) : this(cssName, setters.toList())

    val propertyName: String = cssName.snakeCaseToCamelCase()
    val fileName: String = propertyName.capitalize()
}

private val COLOR_SETTERS = listOf(
    Setter("color", Parameter(styleClassName("Color"), name = "color")),
    Setter("Color.colorString(hexString)", Parameter(STRING, name = "hexString")),
    Setter(
        "Color.colorString(r, g, b)",
        Parameter(INT, name = "r"),
        Parameter(INT, name = "g"),
        Parameter(INT, name = "b")
    ),
    Setter(
        "Color.colorString(r, g, b, a)",
        Parameter(INT, name = "r"),
        Parameter(INT, name = "g"),
        Parameter(INT, name = "b"),
        Parameter(NUMBER, name = "a")
    )
)

data class Setter(
    val template: String,
    val parameters: List<Parameter>,
    val functionName: String? = null
) {
    constructor(parameter: Parameter) : this(template = "$0", parameters = listOf(parameter))

    constructor(
        template: String,
        vararg parameters: Parameter
    ) : this(
        template = template,
        parameters = parameters.toList()
    )
}

data class Parameter(
    val type: ParameterType,
    val name: String = "value",
    val isVararg: Boolean = false,
    val defaultValue: String? = null
) {
    constructor(
        type: TypeName,
        name: String = "value",
        isVararg: Boolean = false,
        defaultValue: String? = null
    ) : this(ParameterType.Exists(type), name, isVararg, defaultValue)
}

sealed class ParameterType {
    class Exists(val type: TypeName) : ParameterType()

    /** Represents a type that doesn't exist yet and needs to be generated */
    class Generate(val values: List<String>) : ParameterType() {
        constructor(vararg values: String) : this(values.toList())
    }
}
