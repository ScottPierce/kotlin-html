// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface Context {
    val writer: HtmlWriter
}

@HtmlDsl
class FileContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class HtmlContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class BodyContext(override val writer: HtmlWriter) : Context {
    operator fun String.unaryPlus() {
        writer.newLine()
        writer.write(this)
    }
}

@HtmlDsl
class HeadContext(override val writer: HtmlWriter) : Context
