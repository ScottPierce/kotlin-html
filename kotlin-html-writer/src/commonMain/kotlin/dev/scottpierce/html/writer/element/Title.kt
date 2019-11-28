@file:Suppress("unused")

package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.AmalgamContext
import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlWriter.title(title: String) {
    pageWriterScope(this) {
        title(title)
    }
}

@HtmlDsl
fun HeadContext.title(title: String) {
    page.newLine()
    page.write("<title>").write(title).write("</title>")
}
