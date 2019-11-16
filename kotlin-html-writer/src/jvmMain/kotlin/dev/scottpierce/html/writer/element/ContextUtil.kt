package dev.scottpierce.html.writer.element

import dev.scottpierce.html.FileCache
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.PlatformWriter
import dev.scottpierce.html.writer.pageWriterScope
import java.io.File

fun HtmlWriter.inlineFile(file: File) {
    pageWriterScope(this) {
        FileContext(this).inlineFile(file)
    }
}

fun HtmlWriterContext.inlineFile(file: File) {
    val fileLines = FileCache.get(file)

    val writerUsesLineSeparator = page.options.newLine == System.lineSeparator()
    val lastIndex = fileLines.lastIndex

    page.newLine()

    for (i in fileLines.indices) {
        val line = fileLines[i]

        page.write(line)

        if (i != lastIndex) {
            if (writerUsesLineSeparator) {
                page.newLine()
            } else {
                page.write(PlatformWriter.lineSeparator)
            }
        }
    }
}
