package dev.scottpierce.html.element

import dev.scottpierce.html.FileCache
import dev.scottpierce.html.write.PlatformWriter
import java.io.File

fun Context.inlineFile(file: File) {
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
