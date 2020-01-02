// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.meta(itemprop: String, content: String) {
    writer {
        this.writeTag("meta")
        if (itemprop != null) this.write(" itemprop=\"").write(itemprop).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.meta(
    vararg attrs: Pair<String, String?>,
    itemprop: String,
    content: String
) {
    writer {
        this.writeTag("meta")
        if (itemprop != null) this.write(" itemprop=\"").write(itemprop).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.meta(
    attrs: List<Pair<String, String?>>,
    itemprop: String,
    content: String
) {
    writer {
        this.writeTag("meta")
        if (itemprop != null) this.write(" itemprop=\"").write(itemprop).write('"')
        if (content != null) this.write(" content=\"").write(content).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HeadContext.meta(itemprop: String, content: String) {
    writer.writeTag("meta")
    if (itemprop != null) writer.write(" itemprop=\"").write(itemprop).write('"')
    if (content != null) writer.write(" content=\"").write(content).write('"')
    writer.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    vararg attrs: Pair<String, String?>,
    itemprop: String,
    content: String
) {
    writer.writeTag("meta")
    if (itemprop != null) writer.write(" itemprop=\"").write(itemprop).write('"')
    if (content != null) writer.write(" content=\"").write(content).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun HeadContext.meta(
    attrs: List<Pair<String, String?>>,
    itemprop: String,
    content: String
) {
    writer.writeTag("meta")
    if (itemprop != null) writer.write(" itemprop=\"").write(itemprop).write('"')
    if (content != null) writer.write(" content=\"").write(content).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}
