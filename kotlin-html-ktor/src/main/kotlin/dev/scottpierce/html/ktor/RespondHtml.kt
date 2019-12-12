@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.html
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.withCharset
import io.ktor.response.respond
import io.ktor.util.cio.bufferedWriter
import kotlinx.coroutines.io.ByteWriteChannel

internal val CONTENT_TYPE_HTML_UTF_8 = ContentType.Text.Html.withCharset(Charsets.UTF_8)

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlWriterOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val func: suspend HtmlOutput.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = CONTENT_TYPE_HTML_UTF_8

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlOutput(it).func()
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlOutgoingContent(
    override val status: HttpStatusCode? = HttpStatusCode.OK,
    private val options: WriteOptions = WriteOptions.default,
    private val docType: DocType? = DocType.Html,
    private val func: suspend HtmlContext.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = CONTENT_TYPE_HTML_UTF_8

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlOutput(it).html(options, docType) { func() }
        }
    }
}

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    docType: DocType? = DocType.Html,
    func: suspend HtmlContext.() -> Unit
): Unit = respond(HtmlOutgoingContent(status, options, docType, func))

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtmlOptions(
    status: HttpStatusCode = HttpStatusCode.OK,
    func: suspend HtmlOutput.() -> Unit
): Unit = respond(HtmlWriterOutgoingContent(status, func))
