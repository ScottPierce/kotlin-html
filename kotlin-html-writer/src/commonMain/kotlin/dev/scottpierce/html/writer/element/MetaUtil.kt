@file:Suppress("unused")

package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.AmalgamContext
import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.pageWriterScope

@HtmlDsl
fun HtmlWriter.metaTitle(title: String) {
    pageWriterScope(this) {
        metaTitle(title)
    }
}

@HtmlDsl
fun HeadContext.metaTitle(title: String) {
    meta(name = "title", content = title)
}

@HtmlDsl
fun HtmlWriter.metaDescription(description: String) {
    pageWriterScope(this) {
        metaDescription(description)
    }
}

@HtmlDsl
fun HeadContext.metaDescription(description: String) {
    meta(name = "description", content = description)
}

@HtmlDsl
fun HtmlWriter.metaCharset(charset: String) {
    pageWriterScope(this) {
        metaCharset(charset)
    }
}

@HtmlDsl
fun HeadContext.metaCharset(charset: String) {
    meta(charset = charset)
}

@HtmlDsl
fun HtmlWriter.metaViewport(viewport: String) {
    pageWriterScope(this) {
        metaViewport(viewport)
    }
}

@HtmlDsl
fun HeadContext.metaViewport(viewport: String) {
    meta(name = "viewport", content = viewport)
}

@HtmlDsl
fun HtmlWriter.metaCharsetUtf8() {
    pageWriterScope(this) {
        metaCharsetUtf8()
    }
}

@HtmlDsl
fun HeadContext.metaCharsetUtf8() {
    metaCharset("utf-8")
}
