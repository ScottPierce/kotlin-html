package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.FileContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlWriter.docType(docType: DocType) {
    pageWriterScope(this) {
        docType(docType)
    }
}

@HtmlDsl
fun FileContext.docType(docType: DocType) {
    page.write("<!DOCTYPE ").write(docType.type!!).write('>')
}

sealed class DocType(val type: String?) {
    object Html : DocType("html")
    class Custom(type: String) : DocType(type)
}
