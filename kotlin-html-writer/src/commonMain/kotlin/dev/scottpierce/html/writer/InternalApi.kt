@file:Suppress("FunctionName")

package dev.scottpierce.html.writer

/**
 * This is to hide APIs that can't be hidden due to inline functions.
 *
 * You probably shouldn't touch things here.
 */
object InternalApi {
    fun PageWriter(htmlWriter: HtmlWriter): PageWriter = dev.scottpierce.html.writer.PageWriter(htmlWriter)
    fun closePageWriter(pageWriter: PageWriter) {
        pageWriter.close()
    }
}
