package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter

@HtmlDsl
fun HtmlWriter.metaTitle(title: String) {
    meta(name = "title", content = title)
}

@HtmlDsl
fun HeadContext.metaTitle(title: String) {
    writer.metaTitle(title)
}

@HtmlDsl
fun HtmlWriter.metaDescription(description: String) {
    meta(name = "description", content = description)
}

@HtmlDsl
fun HeadContext.metaDescription(description: String) {
    writer.metaDescription(description)
}

@HtmlDsl
fun HtmlWriter.metaCharset(charset: String) {
    meta(charset = charset)
}

@HtmlDsl
fun HeadContext.metaCharset(charset: String) {
    writer.metaCharset(charset)
}

@HtmlDsl
fun HtmlWriter.metaViewport(viewport: String) {
    meta(name = "viewport", content = viewport)
}

@HtmlDsl
fun HeadContext.metaViewport(viewport: String) {
    writer.metaViewport(viewport)
}

@HtmlDsl
fun HtmlWriter.metaCharsetUtf8() {
    metaCharset("utf-8")
}

@HtmlDsl
fun HeadContext.metaCharsetUtf8() {
    writer.metaCharsetUtf8()
}
