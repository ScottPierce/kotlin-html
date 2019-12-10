package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlOutput.title(title: String) {
    pageWriterScope(this) {
        HeadContext(this).title(title)
    }
}

@HtmlDsl
fun HeadContext.title(title: String) {
    htmlWriter.newLine()
    htmlWriter.write("<title>").write(title).write("</title>")
}
