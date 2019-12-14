package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.StyleLambda

private val PHONE_ID = StyleBuilderId("StyleBuilder-phone")

@Suppress("unused")
val StyleBuilder.PHONE: StyleBuilderId
    get() = PHONE_ID

@HtmlDsl
inline fun StyleBuilderContext.phone(func: StyleLambda) {
    media(StyleBuilder.PHONE.writerId, func)
}
