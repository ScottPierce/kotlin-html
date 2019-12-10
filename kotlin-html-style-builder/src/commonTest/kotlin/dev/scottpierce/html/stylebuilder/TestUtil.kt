package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringHtmlOutput

infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}
