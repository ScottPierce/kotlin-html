// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.write.HtmlWriter

@DslMarker
annotation class HtmlTag

@HtmlTag
interface Context {
    val writer: HtmlWriter
}

@HtmlTag
class FileContext(override val writer: HtmlWriter) : Context

@HtmlTag
class HtmlContext(override val writer: HtmlWriter) : Context

@HtmlTag
class BodyContext(override val writer: HtmlWriter) : Context

@HtmlTag
class HeadContext(override val writer: HtmlWriter) : Context
