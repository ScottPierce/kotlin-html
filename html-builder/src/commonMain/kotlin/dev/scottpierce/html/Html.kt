@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package dev.scottpierce.html

@DslMarker
annotation class HtmlTag

@HtmlTag
class Html(val docType: DocType = DocType.None) : ParentTag {
    override val attrs: Attributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: HtmlWriter) {
        docType.type?.let {
            writer.write("<!DOCTYPE $it>\n")
        }
        writer.writeTag("html", this)
    }
}

sealed class DocType(val type: String?) {
    object None : DocType(null)
    object Html : DocType("html")
    class Custom(type: String) : DocType(type)
}

inline fun html(doctype: DocType = DocType.None, func: Html.() -> Unit = {}): Html {
    return Html(doctype).apply(func)
}

@HtmlTag
class Head(
    override val attrs: Attributes
) : ParentTag, BodyContent {
    override val children: MutableList<Tag> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeTag("head", this)
    }
}

inline fun Html.head(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Head.() -> Unit = {}
): Head = addChild(attrs, id, classes, style, func) { Head(it) }

inline fun Html.head(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Head.() -> Unit = {}
): Head = addChild(id, classes, style, func) { Head(it) }

@HtmlTag
class Body(
    override val attrs: Attributes
) : ParentTag, BodyContent {
    override val children: MutableList<Tag> = ArrayList(8)

    override fun write(writer: HtmlWriter) {
        writer.writeTag("body", this)
    }
}

inline fun Html.body(
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(id, classes, style, func) { Body(it) }

inline fun Html.body(
    attrs: List<Attribute>,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { Body(it) }

inline fun Html.body(
    vararg attrs: Attribute,
    id: String? = null,
    classes: String? = null,
    style: String? = null,
    func: Body.() -> Unit = {}
): Body = addChild(attrs, id, classes, style, func) { Body(it) }

inline fun <T : Tag> ParentTag.addChild(
    attrs: Array<out Attribute>,
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit,
    provider: (attrs: Attributes) -> T
): T {
    val a = ArrayAttributes(attrs.size + 3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style
    for (attr in attrs) a.add(attr)

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}

inline fun <T : Tag> ParentTag.addChild(
    attrs: List<Attribute>,
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit,
    provider: (attrs: Attributes) -> T
): T {
    val a = ArrayAttributes(attrs.size + 3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style
    for (attr in attrs) a.add(attr)

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}

inline fun <T : Tag> ParentTag.addChild(
    id: String?,
    classes: String?,
    style: String?,
    func: T.() -> Unit,
    provider: (attrs: Attributes) -> T
): T {
    val a = ArrayAttributes(3)
    if (id != null) a["id"] = id
    if (classes != null) a["classes"] = classes
    if (style != null) a["style"] = style

    val tag: T = provider(a)
    children += tag
    return tag.apply(func)
}
