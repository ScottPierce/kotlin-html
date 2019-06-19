package dev.scottpierce.html.ktor

import dev.scottpierce.html.HtmlWriter
import java.io.BufferedWriter

class ChannelHtmlWriter(
    private val writer: BufferedWriter,
    override val isDebug: Boolean = false
) : HtmlWriter {
    private var indent = 0

    override fun newLine() {
        writer.append('\n')
        for (i in 1..indent) {
            writer.append(HtmlWriter.INDENT)
        }
    }

    override fun indent() {
        indent++
    }

    override fun deindent() {
        indent--
    }

    override fun write(code: String): HtmlWriter {
        writer.append(code)
        return this
    }
}
