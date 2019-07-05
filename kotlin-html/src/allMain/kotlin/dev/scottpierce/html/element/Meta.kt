// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter

@HtmlDsl
fun HtmlWriter.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    writeMetaAttributes(name, content, charset, httpEquiv)
    write('>')
}

@HtmlDsl
fun HtmlWriter.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    writeMetaAttributes(name, content, charset, httpEquiv)
    writeAttributes(attrs)
    write('>')
}

@HtmlDsl
fun HtmlWriter.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writeTag("meta")
    writeMetaAttributes(name, content, charset, httpEquiv)
    writeAttributes(attrs)
    write('>')
}

@HtmlDsl
fun HeadContext.meta(
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.meta(name, content, charset, httpEquiv)
}

@HtmlDsl
fun HeadContext.meta(
    vararg attrs: Pair<String, String?>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.writeTag("meta")
    writer.writeMetaAttributes(name, content, charset, httpEquiv)
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    attrs: List<Pair<String, String?>>,
    name: String? = null,
    content: String? = null,
    charset: String? = null,
    httpEquiv: String? = null
) {
    writer.meta(attrs, name, content, charset, httpEquiv)
}

private fun HtmlWriter.writeMetaAttributes(name: String?, content: String?, charset: String?, httpEquiv: String?) {
    if (name != null) write(" name=\"").write(name).write('"')
    if (content != null) write(" content=\"").write(content).write('"')
    if (charset != null) write(" charset=\"").write(charset).write('"')
    if (httpEquiv != null) write(" http-equiv=\"").write(httpEquiv).write('"')
}
