package dev.scottpierce.html.generate

@Suppress("unused")
enum class Tag(
    val tagName: String,
    val supportedAttributes: List<String> = DEFAULT_ATTRIBUTES,
    val contentType: ContentType,
    val isParent: Boolean
) {
    SECTION(tagName = "section", contentType = ContentType.BODY, isParent = true),
    DIV(tagName = "div", contentType = ContentType.BODY, isParent = true)
}

val DEFAULT_ATTRIBUTES: List<String> = listOf("id", "classes", "style")

enum class ContentType {
    HEAD, BODY
}