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
    open val setters: List<Setter>
) {
    ALIGN_ITEMS(
        "align-items",
        Setter(Parameter(ParameterType.Generate(
            "baseline", "center", "flex-start", "flex-end", "stretch", "initial", "inherit"
        )))
    ),
    ALIGN_SELF(
        "align-self",
        Setter(Parameter(ParameterType.Generate(
            "auto", "baseline", "center", "end", "flex-end", "flex-start", "start", "initial", "inherit"
        )))
    ),
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
    BACKGROUND(
        cssName = "background",
        setters = listOf(
            Setter(Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color")),
            Setter(
                template = "\"\$color \$image\"",
                parameters = listOf(
                    Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color"),
                    Parameter(styleClassName("BackgroundImage"), name = "image")
                )
            ),
            Setter(Parameter(STRING, name = "color"))
        )
    ),
    BACKGROUND_ATTACHMENT(
        cssName = "background-attachment",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "scroll", "fixed", "local", "initial", "inherit"
            )))
        )
    ),
    BACKGROUND_CLIP(
        cssName = "background-clip",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "border-box", "padding-box", "content-box", "initial", "inherit"
            )))
        )
    ),
    BACKGROUND_COLOR("background-color", COLOR_SETTERS),
    BACKGROUND_IMAGE(
        "background-image",
        setters = listOf(
            Setter(
                "\"url('\$url')\"",
                Parameter(STRING, "url")
            ),
            Setter("image",
                Parameter(styleClassName("BackgroundImage"), name = "image")
            ),
            Setter("\"\$image\${if (images.isEmpty()) \"\" else images.joinToString(prefix = \", \")}\"",
                Parameter(styleClassName("BackgroundImage"), name = "image"),
                Parameter(styleClassName("BackgroundImage"), isVararg = true, name = "images")
            )
        )
    ),
    BACKGROUND_ORIGIN(
        cssName = "background-origin",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "padding-box", "border-box", "content-box", "initial", "inherit"
            )))
        )
    ),
    BACKGROUND_POSITION(
        cssName = "background-position",
        setters = listOf(
            Setter(
                template = "\"\$x\${if (y == null) \"\" else \" \$y\"}\"",
                parameters = listOf(
                    Parameter(
                        ParameterType.Generate("left", "right", "top", "bottom", "center"),
                        name = "x"
                    ),
                    Parameter(
                        styleClassName("BackgroundPosition").copy(nullable = true),
                        name = "y",
                        defaultValue = "null"
                    )
                )
            ),
            Setter(
                template = "\"\$x\${if (y == null) \"\" else \" \$y\"}\"",
                parameters = listOf(
                    Parameter(DIMENSION, "x"),
                    Parameter(
                        DIMENSION.copy(nullable = true),
                        name = "y",
                        defaultValue = "null"
                    )
                )
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    BACKGROUND_REPEAT(
        cssName = "background-repeat",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "repeat", "repeat-x", "repeat-y", "no-repeat", "space", "round", "initial", "inherit"
            )))
        )
    ),
    BACKGROUND_SIZE(
        cssName = "background-size",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "cover", "contain", "initial", "inherit")))
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
    BORDER_BOTTOM(
        cssName = "border-bottom",
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

            setters += Setter(Parameter(ParameterType.Exists(styleClassName("Border"))))

            setters
        }
    ),
    BORDER_LEFT(
        cssName = "border-left",
        setters = listOf()
    ) {
        override val setters: List<Setter>
            get() = BORDER_BOTTOM.setters
    },
    BORDER_RIGHT(
        cssName = "border-right",
        setters = listOf()
    ) {
        override val setters: List<Setter>
            get() = BORDER_BOTTOM.setters
    },
    BORDER_TOP(
        cssName = "border-top",
        setters = listOf()
    ) {
        override val setters: List<Setter>
            get() = BORDER_BOTTOM.setters
    },
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
            Setter("boxShadows.joinToString()",
                Parameter(styleClassName("BoxShadow"), isVararg = true, name = "boxShadows")
            ),
            Setter(
                template = "BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color, inset = inset)",
                parameters = listOf(
                    Parameter(DIMENSION, name = "hOffset"),
                    Parameter(DIMENSION, name = "vOffset"),
                    Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color"),
                    Parameter(BOOLEAN, name = "inset", defaultValue = "false")
                )
            ),
            Setter(
                template = "BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur, " +
                        "spread = spread, color = color, inset = inset)",
                parameters = listOf(
                    Parameter(DIMENSION, name = "hOffset"),
                    Parameter(DIMENSION, name = "vOffset"),
                    Parameter(DIMENSION, name = "blur"),
                    Parameter(DIMENSION.copy(nullable = true), name = "spread", defaultValue = "null"),
                    Parameter(dev.scottpierce.html.generate.model.COLOR, name = "color"),
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
                template = "Display.NONE",
                functionName = "displayNone",
                parameters = listOf()
            ),
            Setter(
                template = "Display.INLINE",
                functionName = "displayInline",
                parameters = listOf()
            ),
            Setter(
                template = "Display.BLOCK",
                functionName = "displayBlock",
                parameters = listOf()
            ),
            Setter(
                template = "Display.FLEX",
                functionName = "displayFlex",
                parameters = listOf()
            ),
            Setter(
                template = "Display.GRID",
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
            Setter(Parameter(DIMENSION)),
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
        Setter(Parameter(ParameterType.Generate(
            "column", "column-reverse", "row-reverse", "row", "initial", "inherit"
        )))
    ),
    FLEX_WRAP(
        "flex-wrap",
        Setter(Parameter(ParameterType.Generate("nowrap", "wrap", "wrap-reverse", "initial", "inherit")))
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
    JUSTIFY_CONTENT(
        "justify-content",
        Setter(Parameter(ParameterType.Generate(
            "center", "flex-end", "flex-start", "space-around", "space-between", "space-evenly", "initial", "inherit"
        )))
    ),
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
    LIST_STYLE(
        cssName = "list-style",
        setters = listOf(
            Setter(
                template = "\"\$type\${if (position == null) \"\" else \" \$position\"}\"",
                parameters = listOf(
                    Parameter(styleClassName("ListStyleType"), "type"),
                    Parameter(
                        styleClassName("ListStylePosition").copy(nullable = true),
                        name = "position",
                        defaultValue = "null"
                    )
                )
            ),
            Setter(
                template = "\"\$type \$position url('\$imageUrl')\"",
                parameters = listOf(
                    Parameter(styleClassName("ListStyleType"), "type"),
                    Parameter(styleClassName("ListStylePosition"), "position"),
                    Parameter(STRING, "imageUrl")
                )
            ),
            Setter(
                template = "\"\$type \$position \$image\"",
                parameters = listOf(
                    Parameter(styleClassName("ListStyleType"), "type"),
                    Parameter(styleClassName("ListStylePosition"), "position"),
                    Parameter(styleClassName("ListStyleImage"), "image")
                )
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    LIST_STYLE_IMAGE(
        cssName = "list-style-image",
        setters = listOf(
            Setter("\"url('\$imageUrl')\"", Parameter(STRING, "imageUrl")),
            Setter(Parameter(ParameterType.Generate("none", "initial", "inherit")))
        )
    ),
    LIST_STYLE_POSITION(
        cssName = "list-style-position",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate("inside", "outside", "initial", "inherit")))
        )
    ),
    LIST_STYLE_TYPE(
        cssName = "list-style-type",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "disc", "armenian", "circle", "cjk-ideographic", "decimal", "decimal-leading-zero", "georgian",
                "hebrew", "hiragana", "hiragana-iroha", "katakana", "katakana-iroha", "lower-alpha", "lower-greek",
                "lower-latin", "lower-roman", "none", "square", "upper-alpha", "upper-greek", "upper-latin",
                "upper-roman", "initial", "inherit"
            )))
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
    OUTLINE(
        cssName = "outline",
        setters = listOf(
            Setter(
                template = "\"$$0 $$1\${if (color == null) \"\" else \" \$color\"}\"",
                parameters = listOf(
                    Parameter(DIMENSION, name = "width"),
                    Parameter(styleClassName("OutlineStyle"), name = "style"),
                    Parameter(
                        dev.scottpierce.html.generate.model.COLOR.copy(nullable = true),
                        name = "color",
                        defaultValue = "null"
                    )
                )
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    OUTLINE_COLOR("outline-color", COLOR_SETTERS),
    OUTLINE_OFFSET(
        cssName = "outline-offset",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    OUTLINE_STYLE(
        cssName = "outline-style",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "none", "hidden", "dotted", "dashed", "solid", "double", "groove", "ridge", "inset", "outset",
                "initial", "inherit"
            )))
        )
    ),
    OUTLINE_WIDTH(
        cssName = "outline-width",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("medium", "thin", "thick", "initial", "inherit")))
        )
    ),
    OVERFLOW(
        cssName = "overflow",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate(
                "visible", "hidden", "scroll", "auto", "initial", "inherit"
            )))
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
            Setter(Parameter(ParameterType.Generate(
                "static", "relative", "fixed", "absolute", "sticky", "initial", "inherit"
            )))
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
            Setter(Parameter(ParameterType.Generate(
                "left", "right", "center", "justify", "initial", "inherit"
            )))
        )
    ),
    TEXT_DECORATION(
        cssName = "text-decoration",
        setters = listOf(
            Setter(
                template = "\"\${lines.joinToString(separator = \" \")}" +
                        "\${if (color == null) \"\" else \" \$color\"}" +
                        "\${if (style == null) \"\" else \" \$style\"}\"",
                parameters = listOf(
                    Parameter(styleClassName("TextDecorationLine"), isVararg = true, name = "lines"),
                    Parameter(
                        dev.scottpierce.html.generate.model.COLOR.copy(nullable = true),
                        name = "color",
                        defaultValue = "null"
                    ),
                    Parameter(
                        styleClassName("TextDecorationStyle").copy(nullable = true),
                        name = "style",
                        defaultValue = "null"
                    )
                )
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    TEXT_DECORATION_COLOR(
        cssName = "text-decoration-color",
        setters = COLOR_SETTERS
    ),
    TEXT_DECORATION_LINE(
        cssName = "text-decoration-line",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "none", "underline", "overline", "line-through", "initial", "inherit"
            ))),
            Setter(
                template = "lines.joinToString(separator = \" \")",
                parameters = listOf(
                    Parameter(styleClassName("TextDecorationLine"), isVararg = true, name = "lines")
                )
            )
        )
    ),
    TEXT_DECORATION_STYLE(
        cssName = "text-decoration-style",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "solid", "double", "dotted", "dashed", "wavy", "initial", "inherit"
            )))
        )
    ),
    TEXT_TRANSFORM(
        cssName = "text-transform",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "none", "capitalize", "uppercase", "lowercase", "initial", "inherit"
            )))
        )
    ),
    TOP(
        cssName = "top",
        setters = listOf(
            Setter(Parameter(DIMENSION)),
            Setter(Parameter(ParameterType.Generate("auto", "initial", "inherit")))
        )
    ),
    TRANSITION(
        cssName = "transition",
        setters = listOf(
            Setter(
                template = "\"\$property\${if (duration == null) \"\" else \" \${duration.toCssString()}\"}\"",
                parameters = listOf(
                    Parameter(
                        styleClassName("TransitionProperty"),
                        name = "property"
                    ),
                    Parameter(DURATION.copy(nullable = true), name = "duration", defaultValue = "null")
                )
            ),
            Setter(
                template = "\"\$property \${duration.toCssString()} \$timing\${if (delay == null) \"\" else \" \" " +
                        "+ delay.toCssString()}\"",
                parameters = listOf(
                    Parameter(
                        styleClassName("TransitionProperty"),
                        name = "property"
                    ),
                    Parameter(DURATION, name = "duration"),
                    Parameter(
                        styleClassName("TransitionTimingFunction"),
                        name = "timing"
                    ),
                    Parameter(DURATION.copy(nullable = true), name = "delay", defaultValue = "null")
                )
            ),
            Setter(Parameter(CSS_VALUE))
        )
    ),
    TRANSITION_PROPERTY(
        cssName = "transition-property",
        setters = listOf(
            Setter(
                template = "transitionProperties.joinToString(separator = \",\")",
                parameters = listOf(
                    Parameter(
                        styleClassName("TransitionProperty"),
                        name = "transitionProperties",
                        isVararg = true
                    )
                )
            )
        )
    ) {
        override val setters: List<Setter> by lazy {
            val properties = values().map { it.cssName }

            val setter = Setter(Parameter(ParameterType.Generate(
                listOf("none", "all", "initial", "inherit") + properties
            )))

            listOf(setter) + super.setters
        }
    },
    TRANSITION_TIMING_FUNCTION(
        cssName = "transition-timing-function",
        setters = listOf(
            Setter(Parameter(ParameterType.Generate(
                "linear", "ease", "ease-in", "ease-out", "ease-in-out", "initial", "inherit"
            )))
        )
    ),
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
    Setter("Color(hexString)", Parameter(STRING, name = "hexString")),
    Setter(
        "Color(r, g, b)",
        Parameter(INT, name = "r"),
        Parameter(INT, name = "g"),
        Parameter(INT, name = "b")
    ),
    Setter(
        "Color(r, g, b, a)",
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
