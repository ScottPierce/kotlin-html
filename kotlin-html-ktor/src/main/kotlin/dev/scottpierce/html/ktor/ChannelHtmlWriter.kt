package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.AbstractHtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import java.io.BufferedWriter

class ChannelHtmlWriter(
    private val writer: BufferedWriter,
    options: WriteOptions = WriteOptions.default
) : AbstractHtmlWriter(options) {
    override fun writeChar(c: Char) {
        writer.append(c)
    }

    override fun writeString(code: String) {
        writer.append(code)
    }
}
