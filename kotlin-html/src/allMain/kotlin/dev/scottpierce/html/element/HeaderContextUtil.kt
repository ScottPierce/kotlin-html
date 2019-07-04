package dev.scottpierce.html.element

@HtmlDsl
fun HeadContext.metaTitle(title: String) {
    meta(name = "title", content = title)
}

@HtmlDsl
fun HeadContext.metaDescription(description: String) {
    meta(name = "description", content = description)
}

@HtmlDsl
fun HeadContext.metaCharset(charset: String) {
    meta(charset = charset)
}

@HtmlDsl
fun HeadContext.metaViewport(viewport: String) {
    meta(name = "viewport", content = viewport)
}

@HtmlDsl
fun HeadContext.metaCharsetUtf8() {
    metaCharset("utf-8")
}
