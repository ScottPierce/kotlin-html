package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.StyleLambda

private val TABLET_ID = StyleBuilderId("StyleBuilder-phone")

@Suppress("unused")
val StyleBuilder.TABLET: StyleBuilderId
    get() = TABLET_ID

@HtmlDsl
inline fun StyleBuilderContext.tablet(func: StyleLambda) {
    media(StyleBuilder.TABLET, func)
}
