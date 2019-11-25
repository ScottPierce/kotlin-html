package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringBuilderHtmlWriter
import dev.scottpierce.html.writer.element.html
import kotlin.test.Test

@Test
fun basic() {
    StringBuilderHtmlWriter().html {
        style(".test") {
        }
    }
}
