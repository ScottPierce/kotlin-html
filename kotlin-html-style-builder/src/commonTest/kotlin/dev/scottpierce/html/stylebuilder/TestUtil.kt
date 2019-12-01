package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringBuilderHtmlWriter

infix fun StringBuilderHtmlWriter.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}
