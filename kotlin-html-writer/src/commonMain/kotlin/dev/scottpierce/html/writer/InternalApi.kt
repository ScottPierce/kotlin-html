@file:Suppress("FunctionName")

package dev.scottpierce.html.writer

/**
 * This is to hide APIs that can't be hidden due to inline functions.
 *
 * You probably shouldn't touch things here.
 */
object InternalApi {
    fun Page(htmlWriter: HtmlWriter): Page = dev.scottpierce.html.writer.Page(htmlWriter)

    fun closePage(page: Page) {
        page.close()
    }
}
