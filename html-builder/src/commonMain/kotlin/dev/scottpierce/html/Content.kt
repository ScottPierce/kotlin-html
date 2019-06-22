package dev.scottpierce.html

class TextWritable(val text: String) : Writable {
    override fun write(writer: HtmlWriter) {
        writer.write(text)
    }
}

fun ParentTag.plus(text: String) {
    children += TextWritable(text)
}
