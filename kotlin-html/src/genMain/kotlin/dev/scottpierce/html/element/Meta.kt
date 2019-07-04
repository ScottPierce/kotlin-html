// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

fun HtmlWriter.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    this.writeVoidElement("meta", null, null, null, arrayOf("name" to name, "content" to content,
            "charset" to charset, "http-equiv" to httpEquiv))
}

fun HtmlWriter.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    this.writeVoidElement("meta", null, null, null, arrayOf(*attrs, "name" to name, "content" to
            content, "charset" to charset, "http-equiv" to httpEquiv))
}

fun HtmlWriter.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    this.writeVoidElement("meta", null, null, null, arrayOf(*attrs.toTypedArray(), "name" to name,
            "content" to content, "charset" to charset, "http-equiv" to httpEquiv))
}

fun HeadContext.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.writeVoidElement("meta", null, null, null, arrayOf("name" to name, "content" to content,
            "charset" to charset, "http-equiv" to httpEquiv))
}

fun HeadContext.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.writeVoidElement("meta", null, null, null, arrayOf(*attrs, "name" to name, "content" to
            content, "charset" to charset, "http-equiv" to httpEquiv))
}

fun HeadContext.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.writeVoidElement("meta", null, null, null, arrayOf(*attrs.toTypedArray(), "name" to name,
            "content" to content, "charset" to charset, "http-equiv" to httpEquiv))
}
