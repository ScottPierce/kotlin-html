package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriterContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.Page

fun HtmlWriterContext.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?
) {
    page.apply {
        writeTag(tag)
        writeStandardAttributes(id, classes, style)
        write('>')
        indent()
    }
}

fun HtmlWriterContext.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: Array<out Pair<String, String?>>
) {
    page.apply {
        writeTag(tag)
        writeStandardAttributes(id, classes, style)
        writeAttributes(attrs)

        write('>')
        indent()
    }
}

fun HtmlWriterContext.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: List<Pair<String, String?>>
) {
    page.apply {
        writeTag(tag)
        writeStandardAttributes(id, classes, style)
        writeAttributes(attrs)

        write('>')
        indent()
    }
}

fun HtmlWriterContext.writeNormalElementEnd(tag: String) {
    page.apply {
        unindent()
        newLine()
        write("</").write(tag).write('>')
    }
}

fun HtmlWriterContext.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    page.write('>')
}

fun HtmlWriterContext.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: Array<out Pair<String, String?>>
) {
    page.apply {
        writeTag(tag)
        writeStandardAttributes(id, classes, style)
        writeAttributes(attrs)
        write('>')
    }
}

fun HtmlWriterContext.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: List<Pair<String, String?>>
) {
    page.apply {
        writeTag(tag)
        writeStandardAttributes(id, classes, style)
        writeAttributes(attrs)
        write('>')
    }
}

fun HtmlWriterContext.writeTag(tag: String) {
    page.apply {
        if (!isEmpty) newLine()
        write('<').write(tag)
    }
}

fun HtmlWriterContext.writeStandardAttributes(id: String?, classes: String?, style: InlineStyleLambda?) {
    page.apply {
        if (id != null) write(" id=\"").write(id).write('"')
        if (classes != null) write(" class=\"").write(classes).write('"')
        if (style != null) {
            write(" style=\"")
            (this@writeStandardAttributes as InlineStyleContext).style()
            write('"')
        }
    }
}

fun Page.writeAttributes(attrs: Array<out Pair<String, String?>>) {
    for (attr in attrs) {
        writeAttribute(attr)
    }
}

fun Page.writeAttributes(attrs: List<Pair<String, String?>>) {
    for (attr in attrs) {
        writeAttribute(attr)
    }
}

private fun Page.writeAttribute(attr: Pair<String, String?>) {
    attr.checkAttributeKey()
    write(' ').write(attr.first)
    val value: String? = attr.second
    if (value != null) {
        write("=\"").write(value.escapeForHtml()).write('"')
    }
}

fun Pair<String, String?>.checkAttributeKey() {
    val attributeKey = first

    require(attributeKey.isNotEmpty()) { "Attribute name must not be empty. Has value: '$second'" }

    for (c in attributeKey) {
        require(!c.isWhitespace()) { "Attribute name must not contain whitespace character. Attribute: " +
            "'$attributeKey' with value: '$second'" }
    }
}

fun String.escapeForHtml(): String {
    return if (this.needsToBeEscapedForHtml()) {
        val sb = StringBuilder(length + 16)

        for (c in this) {
            if (c == '"') {
                sb.append("&quot;")
            } else {
                sb.append(c)
            }
        }

        sb.toString()
    } else {
        this
    }
}

fun String.needsToBeEscapedForHtml(): Boolean {
    for (c in this) {
        if (c == '"') {
            return true
        }
    }

    return false
}
