package dev.scottpierce.html.writer.element

import dev.scottpierce.html.FileCache
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.HtmlWriterContext
import dev.scottpierce.html.writer.PlatformWriter
import dev.scottpierce.html.writer.writer
import java.io.File

fun HtmlOutput.inlineFile(
    file: File
) {
    writer {
        HtmlContext(this).inlineFile(file)
    }
}

fun HtmlWriterContext.inlineFile(file: File) {
    val fileLines = FileCache.get(file)

    val writerUsesLineSeparator = writer.options.newLine == System.lineSeparator()
    val lastIndex = fileLines.lastIndex

    writer.newLine()

    for (i in fileLines.indices) {
        val line = fileLines[i]

        writer.write(line)

        if (i != lastIndex) {
            if (writerUsesLineSeparator) {
                writer.newLine()
            } else {
                writer.write(PlatformWriter.lineSeparator)
            }
        }
    }
}
