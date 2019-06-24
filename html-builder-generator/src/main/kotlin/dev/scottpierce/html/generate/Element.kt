package dev.scottpierce.html.generate

private const val CAPACITY_LARGE = 16
private const val CAPACITY_MEDIUM = 8
private const val CAPACITY_SMALL = 4

@Suppress("unused")
enum class Element(
    val tagName: String,
    val type: ElementType,
    val supportedAttributes: List<String> = DEFAULT_ATTRIBUTES,
    val contentType: ContentType,
    /**
     * The initial capacity for the list of the [Writable]s. For elements that tend to have lots of children, this
     * should be higher, and for elements that have less children, this should be lower.
     */
    val childrenListInitialCapacity: Int = CAPACITY_MEDIUM
) {
    SECTION(
        tagName = "section",
        type = ElementType.Normal(),
        contentType = ContentType.BODY,
        childrenListInitialCapacity = CAPACITY_LARGE
    ),
    DIV(
        tagName = "div",
        type = ElementType.Normal(),
        contentType = ContentType.BODY
    ),
    SPAN(
        tagName = "span",
        type = ElementType.Normal(),
        contentType = ContentType.BODY,
        childrenListInitialCapacity = CAPACITY_SMALL
    ),
    P(
        tagName = "p",
        type = ElementType.Normal(),
        contentType = ContentType.BODY
    ),
    BR(
        tagName = "br",
        type = ElementType.Void,
        contentType = ContentType.BODY
    ),
    ;
}

val DEFAULT_ATTRIBUTES: List<String> = listOf("id", "classes", "style")

enum class ContentType {
    HEAD,
    BODY
}

// https://www.w3.org/TR/html/syntax.html#void-elements
sealed class ElementType {
    object Void : ElementType()
    object Template : ElementType()
    object RawText : ElementType()
    object EscapableRawText : ElementType()
    object Foreign : ElementType()

    class Normal : ElementType()
}
