package dev.scottpierce.html.element

fun FileContext.docType(docType: DocType) {
    writer.write("<!DOCTYPE ").write(docType.type!!).write('>')
}

sealed class DocType(val type: String?) {
    object None : DocType(null)
    object Html : DocType("html")
    class Custom(type: String) : DocType(type)
}
