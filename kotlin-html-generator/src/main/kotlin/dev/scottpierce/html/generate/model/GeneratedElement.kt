package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName

// https://www.w3.org/TR/html/syntax.html#void-elements
sealed class GeneratedElement(
    val tagName: String,
    val callingContext: Context,
    val supportedAttributes: List<Attr>,
    val fileName: String
) {
    companion object {
        val values: List<GeneratedElement> = listOf(
            Normal(
                tagName = "a",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("href") + Attr.String("target") + Attr.String("rel") + Attr.String("aria-label")
            ),
            Normal(
                tagName = "article",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "aside",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),

            Normal(
                tagName = "body",
                callingContext = Context.Html,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "b",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = listOf()
            ),
            Normal(
                tagName = "button",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("aria-label")
            ),
            Void(
                tagName = "br",
                callingContext = Context.Body
            ),
            Normal(
                tagName = "caption",
                callingContext = Context.Table,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "colgroup",
                callingContext = Context.Table,
                childrenContext = Context.ColGroup,
                supportedAttributes = listOf()
            ),
            Void(
                tagName = "col",
                callingContext = Context.Table,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(Attr.IntString("span"))
            ),
            Void(
                tagName = "col",
                callingContext = Context.ColGroup,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(Attr.IntString("span"))
            ),
            Normal(
                tagName = "details",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "div",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "em",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = listOf()
            ),
            Normal(
                tagName = "figcaption",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "figure",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),

            Normal(
                tagName = "footer",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h1",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h2",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h3",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h4",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h5",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "h6",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "head",
                callingContext = Context.Html,
                childrenContext = Context.Head
            ),
            Normal(
                tagName = "header",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Void(
                tagName = "hr",
                callingContext = Context.Body
            ),
//            Normal(
//                tagName = "html",
//                callingContext = Context.File,
//                childrenContext = Context.Html,
//                supportedAttributes = listOf(
//                    Attr.CLASSES,
//                    Attr.STYLE,
//                    Attr.String("lang")
//                )
//            ),
            Normal(
                tagName = "i",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Void(
                tagName = "img",
                callingContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(
                    Attr.String("src"),
                    Attr.String("alt"),
                    Attr.String("width"),
                    Attr.String("height")
                )
            ),
            Normal(
                tagName = "input",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("type") + Attr.String("maxLength") + Attr.String("value") + Attr.String("name") + Attr.String("placeholder") + Attr.String("aria-label") + Attr.String(name = "aria-labelledby", functionName = "ariaLabelledBy")
            ),
            Normal(
                tagName = "label",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String(name = "for", functionName = "forId")
            ),
            Normal(
                tagName = "li",
                callingContext = Context.Ul,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("value")
            ),
            Void(
                tagName = "link",
                callingContext = Context.BaseHtml,
                supportedAttributes = listOf(
                    Attr.String("href"),
                    Attr.String("rel"),
                    Attr.String("hreflang"),
                    Attr.String("media"),
                    Attr.String("type"),
                    Attr.String("sizes")
                )
            ),
            Normal(
                tagName = "mark",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "main",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),

            Void(
                tagName = "meta",
                callingContext = Context.Head,
                supportedAttributes = listOf(
                    Attr.String("name"),
                    Attr.String("content"),
                    Attr.String("charset"),
                    Attr.String("http-equiv")
                )
            ),
            Void(
                tagName = "meta",
                callingContext = Context.Body,
                supportedAttributes = listOf(
                    Attr.String("itemprop"),
                    Attr.String("content")
                ),
                fileName = "MetaBodyDsl"
            ),
            Normal(
                tagName = "nav",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "option",
                callingContext = Context.Select,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("value")
            ),
            Normal(
                tagName = "p",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "script",
                callingContext = Context.BaseHtml,
                childrenContext = Context.Script,
                supportedAttributes = listOf(
                    Attr.Boolean("async"),
                    Attr.Boolean("defer"),
                    Attr.String("type")
                )
            ),
            Normal(
                tagName = "section",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "select",
                callingContext = Context.Body,
                childrenContext = Context.Select
            ),
            Void(
                tagName = "source",
                callingContext = Context.Video,
                supportedAttributes = listOf(
                    Attr.String("src"),
                    Attr.String("type")
                )
            ),
            Normal(
                tagName = "span",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "strong",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = listOf()
            ),
            Normal(
                tagName = "summary",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "table",
                callingContext = Context.Body,
                childrenContext = Context.Table
            ),
            Normal(
                tagName = "tbody",
                callingContext = Context.Table,
                childrenContext = Context.Table
            ),
            Normal(
                tagName = "tfoot",
                callingContext = Context.Table,
                childrenContext = Context.Table
            ),
            Normal(
                tagName = "th",
                callingContext = Context.TableRow,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(
                    Attr.IntString("colspan"),
                    Attr.IntString("rowspan"),
                    Attr.String("abbr"),
                    Attr.String("headers"),
                    Attr.String("scope"),
                    Attr.String("sorted")
                )
            ),
            Normal(
                tagName = "thead",
                callingContext = Context.Table,
                childrenContext = Context.Table
            ),
            Normal(
                tagName = "time",
                callingContext = Context.Body,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + Attr.String("datetime")
            ),
            Normal(
                tagName = "tr",
                callingContext = Context.Table,
                childrenContext = Context.TableRow
            ),
            Normal(
                tagName = "td",
                callingContext = Context.TableRow,
                childrenContext = Context.Body,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(
                    Attr.IntString("colspan"),
                    Attr.IntString("rowspan"),
                    Attr.String("headers")
                )
            ),
            Normal(
                tagName = "video",
                callingContext = Context.Body,
                childrenContext = Context.Video,
                supportedAttributes = STANDARD_ATTRIBUTES + listOf(
                    Attr.Boolean("muted"),
                    Attr.Boolean("playsinline"),
                    Attr.Boolean("autoplay"),
                    Attr.Boolean("loop"),
                    Attr.String("preload"),
                    Attr.String("poster")
                )
            ),
            Normal(
                tagName = "ul",
                callingContext = Context.Body,
                childrenContext = Context.Ul
            )
        )
    }

    class Normal(
        tagName: String,
        callingContext: Context,
        val childrenContext: Context,
        supportedAttributes: List<Attr> = STANDARD_ATTRIBUTES,
        fileName: String = "${tagName.capitalize()}Dsl"
    ) : GeneratedElement(
        tagName,
        callingContext,
        supportedAttributes,
        fileName = fileName
    )

    class Void(
        tagName: String,
        callingContext: Context,
        supportedAttributes: List<Attr> = STANDARD_ATTRIBUTES,
        fileName: String = "${tagName.capitalize()}Dsl"
    ) : GeneratedElement(
        tagName,
        callingContext,
        supportedAttributes,
        fileName = fileName
    )
}

enum class Context {
    BaseHtml,
    Body,
    ColGroup,
    Col,
    Html,
    Head,
    Script,
    Select,
    Table,
    TableRow,
    Ul,
    Video,
    ;

    val contextClassName: ClassName by lazy {
        ClassName(
            packageName = "dev.scottpierce.html.writer",
            simpleNames = listOf("${name}Context")
        )
    }
}

sealed class Attr(
    val name: kotlin.String,
    val functionName: kotlin.String,
    val className: TypeName,
    val defaultValue: kotlin.String?,
    val modifiers: List<KModifier>
) {
    companion object {
        val ID = String("id")
        val CLASSES = String("classes")
        val STYLE = Custom(
            name = "style",
            functionName = "style",
            typeName = INLINE_STYLE_LAMBDA.copy(nullable = true),
            defaultValue = "null",
            modifiers = listOf(KModifier.NOINLINE)
        )
    }

    override fun toString(): kotlin.String = name

    class String(
        name: kotlin.String,
        functionName: kotlin.String = name.snakeCaseToCamelCase(),
        isNullable: kotlin.Boolean = true,
        defaultValue: kotlin.String? = "null"
    ) : Attr(name, functionName, STRING.copy(nullable = isNullable, tags = mapOf()), defaultValue, listOf())

    class Boolean(
        name: kotlin.String,
        functionName: kotlin.String = name.snakeCaseToCamelCase()
    ) : Attr(name, functionName, BOOLEAN, "false", listOf())

    class IntString(
        name: kotlin.String,
        functionName: kotlin.String = name.snakeCaseToCamelCase()
    ) : Attr(name, functionName, INT.copy(nullable = true), defaultValue = "null", modifiers = listOf())

    class Custom(
        name: kotlin.String,
        functionName: kotlin.String,
        typeName: TypeName,
        defaultValue: kotlin.String?,
        modifiers: List<KModifier> = listOf()
    ) : Attr(name, functionName, typeName, defaultValue, modifiers)
}

val STANDARD_ATTRIBUTES: List<Attr> = listOf(
    Attr.ID,
    Attr.CLASSES,
    Attr.STYLE
)
