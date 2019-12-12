package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.insertWriter

private const val KEY_STYLESHEET = "page-stylesheet"

/**
 * Retrieves the global [StyleSheetBuilder] for the [HtmlWriter]. If it doesn't exist, it will be created automatically.
 */
 val HtmlWriter.styleSheetWriter: HtmlWriter
    get() = writer(KEY_STYLESHEET)

fun test() {
    StringHtmlOutput().html {
        head {
            insertWriter("styleSheet") {
                
            }
        }
    }
}
