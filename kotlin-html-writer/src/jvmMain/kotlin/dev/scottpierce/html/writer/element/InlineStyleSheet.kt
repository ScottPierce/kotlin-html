package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope
import java.io.File

fun HtmlWriter.inlineStyleSheet(file: File) {
    pageWriterScope(this) {
        HtmlContext(this).inlineStyleSheet(file)
    }
}

fun HtmlWriterContext.inlineStyleSheet(file: File) {
    writer.apply {
        writeTag("style")
        write('>')
        indent()
        inlineFile(file)
        writeNormalElementEnd("style")
    }
}
