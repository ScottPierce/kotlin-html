package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions

fun testWriter(
    options: WriteOptions = WriteOptions.readable.copy(indent = "    "),
    func: StringHtmlOutput.() -> Unit
): StringHtmlOutput {
    return StringHtmlOutput(options).apply(func)
}

infix fun StringHtmlOutput.assertEquals(expected: () -> String) {
    kotlin.test.assertEquals(expected(), this.toString())
}
