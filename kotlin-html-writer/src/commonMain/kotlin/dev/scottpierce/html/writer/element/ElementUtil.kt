package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.PageWriter
import dev.scottpierce.html.writer.style.InlineStyleContext
import dev.scottpierce.html.writer.style.InlineStyleLambda

fun PageWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    write('>')
    indent()
}

fun PageWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: Array<out Pair<String, String?>>
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    writeAttributes(attrs)

    write('>')
    indent()
}

fun PageWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: List<Pair<String, String?>>
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    writeAttributes(attrs)

    write('>')
    indent()
}

fun PageWriter.writeNormalElementEnd(tag: String) {
    unindent()
    newLine()
    write("</").write(tag).write('>')
}

fun PageWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    write('>')
}

fun PageWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: Array<out Pair<String, String?>>
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    writeAttributes(attrs)
    write('>')
}

fun PageWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: InlineStyleLambda?,
    attrs: List<Pair<String, String?>>
) {
    writeTag(tag)
    writeStandardAttributes(id, classes, style)
    writeAttributes(attrs)
    write('>')
}

fun PageWriter.writeTag(tag: String) {
    if (!isEmpty) newLine()
    write('<').write(tag)
}

fun PageWriter.writeStandardAttributes(id: String?, classes: String?, style: InlineStyleLambda?) {
    if (id != null) write(" id=\"").write(id).write('"')
    if (classes != null) write(" class=\"").write(classes).write('"')
    if (style != null) {
        write(" style=\"")
        InlineStyleContext(this).style()
        write('"')
    }
}

fun PageWriter.writeAttributes(attrs: Array<out Pair<String, String?>>) {
    for (attr in attrs) {
        writeAttribute(attr)
    }
}

fun PageWriter.writeAttributes(attrs: List<Pair<String, String?>>) {
    for (attr in attrs) {
        writeAttribute(attr)
    }
}

private fun PageWriter.writeAttribute(attr: Pair<String, String?>) {
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
