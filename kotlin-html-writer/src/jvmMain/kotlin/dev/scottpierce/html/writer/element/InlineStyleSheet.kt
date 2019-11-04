package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import java.io.File

fun HtmlWriter.inlineStyleSheet(file: File) {
    writeTag("style")
    write('>')
    indent()
    inlineFile(file)
    writeNormalElementEnd("style")
}

fun Context.inlineStyleSheet(file: File) {
    writer.inlineStyleSheet(file = file)
}
