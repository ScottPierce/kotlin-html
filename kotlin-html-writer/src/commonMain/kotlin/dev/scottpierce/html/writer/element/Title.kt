package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlWriter.title(title: String) {
    pageWriterScope(this) {
        HeadContext(this).title(title)
    }
}

@HtmlDsl
fun HeadContext.title(title: String) {
    writer.newLine()
    writer.write("<title>").write(title).write("</title>")
}
