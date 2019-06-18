package dev.scottpierce.html

@DslMarker
annotation class HtmlTag

@HtmlTag
class Html : ParentTag {
    override val attributes: MutableAttributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: Writer) {
        writer.writeTag("html", this)
    }
}

@HtmlTag
class Head : ParentTag, HeadContent {
    override val attributes: MutableAttributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: Writer) {
        writer.writeTag("head", this)
    }
}

@HtmlTag
class Body : ParentTag, BodyContent {
    override val attributes: MutableAttributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: Writer) {
        writer.writeTag("body", this)
    }
}

@HtmlTag
class Section : ParentTag, BodyContent {
    override val attributes: MutableAttributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: Writer) {
        writer.writeTag("section", this)
    }
}

@HtmlTag
class Div : ParentTag, BodyContent {
    override val attributes: MutableAttributes = ArrayAttributes()
    override val children: MutableList<Tag> = ArrayList()

    override fun write(writer: Writer) {
        writer.writeTag("div", this)
    }
}

inline fun <T : Tag> ParentTag.addChild(child: T, id: String?, classes: String?, func: T.() -> Unit): T {
    children += child
    if (id != null) {
        attributes["id"] = id
    }
    if (classes != null) {
        attributes["classes"] = classes
    }
    return child.apply(func)
}

inline fun html(vararg attrs: Pair<String, String?>, func: Html.() -> Unit = {}): Html {
    return Html().apply(func)
}

inline fun Html.head(func: Head.() -> Unit = {}): Head =
    addChild(child = Head(), id = null, classes = null, func = func)

inline fun Html.body(func: Body.() -> Unit = {}): Body =
    addChild(child = Body(), id = null, classes = null, func = func)

inline fun <T> T.section(
    id: String? = null,
    classes: String? = null,
    func: Section.() -> Unit = {}
): Section where T : ParentTag, T : BodyContent = addChild(child = Section(), id = id, classes = classes, func = func)

inline fun <T> T.div(
    id: String? = null,
    classes: String? = null,
    func: Div.() -> Unit = {}
): Div where T : ParentTag, T : BodyContent = addChild(child = Div(), id = id, classes = classes, func = func)

fun test() {
    val html = html(doctype = "") {

        head {

        }

        body {
            div {

            }
        }
    }

    val writer = StringBuilderWriter(true)
    html.write(writer)
}