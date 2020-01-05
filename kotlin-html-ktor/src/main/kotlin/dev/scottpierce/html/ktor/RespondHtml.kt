@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.StringHtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.html
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.withCharset
import io.ktor.response.respondText

object RespondHtml {
    val CONTENT_TYPE_HTML_UTF_8 = ContentType.Text.Html.withCharset(Charsets.UTF_8)
}

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend inline fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    docType: DocType? = DocType.Html,
    lang: String? = null,
    func: HtmlContext.() -> Unit
) {
    val output = StringHtmlOutput(options, 1024)
    output.html(docType = docType, lang = lang) {
        func()
    }
    respondText(RespondHtml.CONTENT_TYPE_HTML_UTF_8, status) {
        output.toString()
    }
}

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend inline fun ApplicationCall.respondHtmlOutput(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    func: HtmlOutput.() -> Unit
) {
    val output = StringHtmlOutput(options, 1024)
    output.func()
    respondText(RespondHtml.CONTENT_TYPE_HTML_UTF_8, status) {
        output.toString()
    }
}
