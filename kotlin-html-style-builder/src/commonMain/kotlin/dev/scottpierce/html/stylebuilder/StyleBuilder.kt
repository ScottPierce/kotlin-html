package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.HtmlWriterId
import dev.scottpierce.html.writer.StyleLambda
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.style.style

object StyleBuilder {
    val NORMAL = StyleBuilderId("StyleBuilder-normal")
}

inline class StyleBuilderId(val writerId: HtmlWriterId)

@HtmlDsl
fun BaseHtmlContext.style(selector: String, func: StyleBuilderContext.() -> Unit) {
    val rootWriter = writer
    val styleSheetWriter = writer.writer(StyleBuilder.NORMAL.writerId)

    StyleSheetContext(styleSheetWriter).style(selector) {
        StyleBuilderContext(
            writer = styleSheetWriter,
            selector = selector,
            rootWriter = rootWriter
        ).func()
    }
}

@HtmlDsl
class StyleBuilderContext(
    override val writer: HtmlWriter,
    val selector: String,
    val rootWriter: HtmlWriter
) : BaseStyleContext {
    @HtmlDsl
    inline fun media(name: HtmlWriterId, func: StyleLambda) {
        StyleSheetContext(rootWriter.writer(name)).style(selector, func)
    }
}
