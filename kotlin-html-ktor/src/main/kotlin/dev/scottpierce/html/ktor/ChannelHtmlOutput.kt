package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import java.io.BufferedWriter

class ChannelHtmlOutput(
    private val writer: BufferedWriter,
    override val options: WriteOptions = WriteOptions.default
) : HtmlOutput {
    override fun write(c: Char) {
        writer.append(c)
    }

    override fun write(code: CharSequence) {
        writer.append(code)
    }
}
