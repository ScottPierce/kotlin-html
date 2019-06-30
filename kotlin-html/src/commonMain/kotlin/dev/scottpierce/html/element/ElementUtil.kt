package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter

fun HtmlWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: String?
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    write('>')
    indent()
}

fun HtmlWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: String?,
    attrs: Array<out Pair<String, String?>>
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    writeAttributes(attrs)

    write('>')
    indent()
}

fun HtmlWriter.writeNormalElementStart(
    tag: String,
    id: String?,
    classes: String?,
    style: String?,
    attrs: Iterable<Pair<String, String?>>
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    writeAttributes(attrs)

    write('>')
    indent()
}

fun HtmlWriter.writeNormalElementEnd(tag: String) {
    deindent()
    newLine()
    write("</").write(tag).write('>')
}

fun HtmlWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: String?
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    write('>')
}

fun HtmlWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: String?,
    attrs: Array<out Pair<String, String?>>
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    writeAttributes(attrs)
    write('>')
}

fun HtmlWriter.writeVoidElement(
    tag: String,
    id: String?,
    classes: String?,
    style: String?,
    attrs: Iterable<Pair<String, String?>>
) {
    writeTag(tag)
    writeBasicAttributes(id, classes, style)
    writeAttributes(attrs)
    write('>')
}

private fun HtmlWriter.writeTag(tag: String) {
    if (!isEmpty) newLine()
    write('<').write(tag)
}

private fun HtmlWriter.writeBasicAttributes(id: String?, classes: String?, style: String?) {
    if (id != null) write(" id=\"").write(id).write('"')
    if (classes != null) write(" classes=\"").write(classes).write('"')
    if (style != null) write(" style=\"").write(style).write('"')
}

private fun HtmlWriter.writeAttributes(attrs: Array<out Pair<String, String?>>) {
    for (attr in attrs) {
        attr.checkAttributeKey()
        write(' ').write(attr.first)
        val value: String? = attr.second
        if (value != null) {
            write("=\"").write(value).write('"')
        }
    }
}

private fun HtmlWriter.writeAttributes(attrs: Iterable<Pair<String, String?>>) {
    for (attr in attrs) {
        attr.checkAttributeKey()
        write(' ').write(attr.first)
        val value: String? = attr.second
        if (value != null) {
            write("=\"").write(value).write('"')
        }
    }
}

private fun Pair<String, String?>.checkAttributeKey() {
    val attributeKey = first

    if (attributeKey.isEmpty()) {
        throw IllegalArgumentException("Attribute name must not be empty. Has value: '$second'")
    }

    for (c in attributeKey) {
        if (c.isWhitespace()) {
            throw IllegalArgumentException("Attribute name must not contain whitespace character. Attribute: " +
                    "'$attributeKey' with value: '$second'")
        }
    }
}
