package dev.scottpierce.html.generate.model

import com.squareup.kotlinpoet.ClassName

// https://www.w3.org/TR/html/syntax.html#void-elements
sealed class Element(
    val tagName: String,
    val callingContext: Context,
    val supportedAttributes: List<String>
) {
    companion object {
        val values: List<Element> = listOf(
            Normal(
                tagName = "html",
                callingContext = Context.File,
                childrenContext = Context.Html
            ),
            Normal(
                tagName = "body",
                callingContext = Context.Html,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "head",
                callingContext = Context.Html,
                childrenContext = Context.Head
            ),
            Normal(
                tagName = "section",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "div",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "span",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "p",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Void(
                tagName = "br",
                callingContext = Context.Body
            ),
            Void(
                tagName = "meta",
                callingContext = Context.Head,
                supportedAttributes = listOf("name", "content", "charset", "http-equiv")
            )
        )
    }

    class Normal(
        tagName: String,
        callingContext: Context,
        val childrenContext: Context,
        supportedAttributes: List<String> = STANDARD_ATTRIBUTES
    ) : Element(
        tagName,
        callingContext,
        supportedAttributes
    )

    class Void(
        tagName: String,
        callingContext: Context,
        supportedAttributes: List<String> = STANDARD_ATTRIBUTES
    ) : Element(
        tagName,
        callingContext,
        supportedAttributes
    )
}

enum class Context {
    File,
    Html,
    Body,
    Head,
    ;

    companion object {
        val className = ClassName("dev.scottpierce.html.element", "Context")
    }

    val contextClassName = ClassName("dev.scottpierce.html.element", "${name}Context")
}

val STANDARD_ATTRIBUTES: List<String> = listOf("id", "classes", "style")
