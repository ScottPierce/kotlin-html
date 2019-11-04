package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter

@HtmlDsl
fun HtmlWriter.title(title: String) {
    newLine()
    write("<title>").write(title).write("</title>")
}

@HtmlDsl
fun HeadContext.title(title: String) {
    writer.title(title)
}
