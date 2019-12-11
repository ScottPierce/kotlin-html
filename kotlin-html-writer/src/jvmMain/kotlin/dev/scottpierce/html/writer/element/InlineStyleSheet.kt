package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.HtmlWriterContext
import dev.scottpierce.html.writer.writer
import java.io.File

fun HtmlOutput.inlineStyleSheet(file: File) {
    writer {
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
