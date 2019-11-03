package dev.scottpierce.html.ktor

import dev.scottpierce.html.style.Test
import dev.scottpierce.html.write.AbstractHtmlWriter
import dev.scottpierce.html.write.WriteOptions
import java.io.BufferedWriter

class ChannelHtmlWriter(
    private val writer: BufferedWriter,
    options: WriteOptions = WriteOptions.default
) : AbstractHtmlWriter(options) {
    override fun writeChar(c: Char) {
        writer.append(c)
    }

    override fun writeCharSequence(code: CharSequence) {
        writer.append(code)
    }
}
