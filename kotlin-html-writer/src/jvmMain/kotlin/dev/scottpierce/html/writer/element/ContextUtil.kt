package dev.scottpierce.html.writer.element

import dev.scottpierce.html.FileCache
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.PlatformWriter
import dev.scottpierce.html.writer.pageWriterScope
import java.io.File

fun HtmlOutput.inlineFile(file: File) {
    pageWriterScope(this) {
        FileContext(this).inlineFile(file)
    }
}

fun HtmlWriterContext.inlineFile(file: File) {
    val fileLines = FileCache.get(file)

    val writerUsesLineSeparator = htmlWriter.options.newLine == System.lineSeparator()
    val lastIndex = fileLines.lastIndex

    htmlWriter.newLine()

    for (i in fileLines.indices) {
        val line = fileLines[i]

        htmlWriter.write(line)

        if (i != lastIndex) {
            if (writerUsesLineSeparator) {
                htmlWriter.newLine()
            } else {
                htmlWriter.write(PlatformWriter.lineSeparator)
            }
        }
    }
}
