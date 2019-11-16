package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.Page

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val page: Page
}

@HtmlDsl
inline class FileContext(override val page: Page) : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
inline class HtmlContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
inline class HeadContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
inline class ScriptContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
inline class BodyContext(override val page: Page) : BaseHtmlContext, HasText

@HtmlDsl
inline class SelectContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
inline class UlContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
inline class VideoContext(override val page: Page) : BaseHtmlContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun String.unaryPlus() {
        page.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}
