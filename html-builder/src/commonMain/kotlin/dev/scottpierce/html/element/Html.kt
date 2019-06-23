@file:Suppress("unused")

package dev.scottpierce.html.element

import dev.scottpierce.html.ArrayMap
import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.Writable
import dev.scottpierce.html.write.writeElement

interface Html : ContentElement

@HtmlTag
class HtmlBuilder(
    val docType: DocType = DocType.None,
    override val attrs: MutableAttributes = ArrayMap()
) : Html, MutableContentElement {
    override val children: MutableList<Writable> = ArrayList()

    override fun write(writer: HtmlWriter) {
        docType.type?.let {
            writer.write("<!DOCTYPE $it>\n")
        }
        writer.writeElement("html", this)
    }
}

sealed class DocType(val type: String?) {
    object None : DocType(null)
    object Html : DocType("html")
    class Custom(type: String) : DocType(type)
}

inline fun html(
    docType: DocType = DocType.None,
    attrs: List<Attribute> = listOf(),
    func: HtmlBuilder.() -> Unit = {}
): Html {
    val a = ArrayMap(attrs.size)
    return HtmlBuilder(docType, attrs = a).apply(func)
}
