package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope
import java.io.File

fun HtmlOutput.inlineStyleSheet(file: File) {
    pageWriterScope(this) {
        HtmlContext(this).inlineStyleSheet(file)
    }
}

fun HtmlWriterContext.inlineStyleSheet(file: File) {
    htmlWriter.apply {
        writeTag("style")
        write('>')
        indent()
        inlineFile(file)
        writeNormalElementEnd("style")
    }
}
