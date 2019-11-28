package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.style.style

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val page: Page
}

@HtmlDsl
interface FileContext : HtmlWriterContext

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
interface HtmlContext : BaseHtmlContext

@HtmlDsl
interface HeadContext : BaseHtmlContext

@HtmlDsl
interface ScriptContext : BaseHtmlContext

@HtmlDsl
interface BodyContext : BaseHtmlContext, HasText

@HtmlDsl
interface SelectContext : BaseHtmlContext

@HtmlDsl
interface UlContext : BaseHtmlContext

@HtmlDsl
interface VideoContext : BaseHtmlContext

@HtmlDsl
interface StyleSheetContext : HtmlWriterContext {
    @HtmlDsl
    operator fun String.invoke(func: StyleLambda) = style(this, func)
}

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
interface InlineStyleContext : BaseStyleContext

@HtmlDsl
interface StyleContext : BaseStyleContext

@HtmlDsl
class AmalgamContext(
    override val page: Page
) : FileContext,
    HtmlContext,
    HeadContext,
    ScriptContext,
    BodyContext,
    SelectContext,
    UlContext,
    VideoContext,
    StyleSheetContext,
    InlineStyleContext,
    StyleContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun String.unaryPlus() {
        page.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}

typealias BaseStyleLambda = BaseStyleContext.() -> Unit

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit