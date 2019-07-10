package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.STRING

// https://www.w3.org/TR/html/syntax.html#void-elements
sealed class Element(
    val tagName: String,
    val callingContext: Context,
    val supportedAttributes: List<Attr>
) {
    companion object {
        val values: List<Element> = listOf(
            Normal(
                tagName = "a",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "body",
                callingContext = Context.Html,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "button",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Void(
                tagName = "br",
                callingContext = Context.Body
            ),
            Normal(
                tagName = "div",
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
                tagName = "html",
                callingContext = Context.File,
                childrenContext = Context.Html
            ),
            Void(
                tagName = "link",
                callingContext = Context.Head,
                supportedAttributes = listOf(
                    Attr.String("href"),
                    Attr.String("rel"),
                    Attr.String("hreflang"),
                    Attr.String("media"),
                    Attr.String("type"),
                    Attr.String("sizes")
                )
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
                callingContext = Context.Head,
                childrenContext = Context.Script,
                supportedAttributes = listOf(
                    Attr.Boolean("async"),
                    Attr.Boolean("defer"),
                    Attr.String("src")
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
            Normal(
                tagName = "span",
                callingContext = Context.Body,
                childrenContext = Context.Body
            )
        )
    }

    class Normal(
        tagName: String,
        callingContext: Context,
        val childrenContext: Context,
        supportedAttributes: List<Attr> = STANDARD_ATTRIBUTES
    ) : Element(
        tagName,
        callingContext,
        supportedAttributes
    )

    class Void(
        tagName: String,
        callingContext: Context,
        supportedAttributes: List<Attr> = STANDARD_ATTRIBUTES
    ) : Element(
        tagName,
        callingContext,
        supportedAttributes
    )
}

enum class Context {
    File,
    Html,
    Head,
    Script,
    Body,
    Select,
    ;

    companion object {
        val className = ClassName("dev.scottpierce.html.element", "Context")
    }

    val contextClassName = ClassName("dev.scottpierce.html.element", "${name}Context")
}

sealed class Attr(
    val name: kotlin.String,
    val className: ClassName,
    val defaultValue: kotlin.String
) {
    companion object {
        val ID = String("id")
        val CLASSES = String("classes")
        val STYLE = Custom("style", dev.scottpierce.html.generate.model.STYLE.copy(nullable = true), "null")
    }

    override fun toString(): kotlin.String = name

    class String(name: kotlin.String) : Attr(name, STRING.copy(nullable = true), "null")
    class Boolean(name: kotlin.String) : Attr(name, BOOLEAN, "false")
    class Custom(name: kotlin.String, className: ClassName, defaultValue: kotlin.String) : Attr(name, className, defaultValue)
}

val STANDARD_ATTRIBUTES: List<Attr> = listOf(
    Attr.ID,
    Attr.CLASSES,
    Attr.STYLE
)
