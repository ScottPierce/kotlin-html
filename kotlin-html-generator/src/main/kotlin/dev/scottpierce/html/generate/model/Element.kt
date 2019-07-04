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
                tagName = "body",
                callingContext = Context.Html,
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
                tagName = "meta",
                callingContext = Context.Head,
                supportedAttributes = listOf("name", "content", "charset", "http-equiv")
            ),
            Normal(
                tagName = "p",
                callingContext = Context.Body,
                childrenContext = Context.Body
            ),
            Normal(
                tagName = "section",
                callingContext = Context.Body,
                childrenContext = Context.Body
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
