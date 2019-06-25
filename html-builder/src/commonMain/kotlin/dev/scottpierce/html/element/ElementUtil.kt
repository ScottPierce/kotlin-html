package dev.scottpierce.html.element

import dev.scottpierce.html.ArrayMap

@DslMarker
annotation class HtmlTag

inline fun <T : MutableElement> MutableContentElement.addChild(
    attrs: Array<out Attribute>,
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit = {},
    provider: (attrs: MutableAttributes) -> T
): T {
    val a = ArrayMap<String, String?>(attrs.size + 3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style
    for (attr in attrs) a.add(attr)

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}

inline fun <T : MutableElement> MutableContentElement.addChild(
    attrs: List<Attribute>,
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit = {},
    provider: (attrs: MutableAttributes) -> T
): T {
    val a = ArrayMap<String, String?>(attrs.size + 3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style
    for (attr in attrs) a.add(attr)

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}

inline fun <T : MutableElement> MutableContentElement.addChild(
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit = {},
    provider: (attrs: MutableAttributes) -> T
): T {
    val a = ArrayMap<String, String?>(3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}
