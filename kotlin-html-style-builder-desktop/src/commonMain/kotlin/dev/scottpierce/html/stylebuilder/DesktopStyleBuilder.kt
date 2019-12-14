package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.StyleLambda

private val DESKTOP_ID = StyleBuilderId("StyleBuilder-phone")

@Suppress("unused")
val StyleBuilder.DESKTOP: StyleBuilderId
    get() = DESKTOP_ID

@HtmlDsl
inline fun StyleBuilderContext.desktop(func: StyleLambda) {
    media(StyleBuilder.DESKTOP.writerId, func)
}
