package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import java.io.BufferedWriter

class ChannelHtmlWriter(
    private val writer: BufferedWriter,
    override val options: WriteOptions = WriteOptions.default
) : HtmlWriter {
    override fun write(c: Char) {
        writer.append(c)
    }

    override fun write(code: CharSequence) {
        writer.append(code)
    }
}
