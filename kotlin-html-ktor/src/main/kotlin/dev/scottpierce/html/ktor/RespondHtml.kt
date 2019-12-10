@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.WriteOptions
import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.FileContext
import dev.scottpierce.html.writer.element.HtmlContext
import dev.scottpierce.html.writer.element.docType
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
    private val options: WriteOptions,
    private val func: suspend HtmlWriter.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = CONTENT_TYPE_HTML_UTF_8

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlWriter(it, options).func()
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlFileOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val func: suspend FileContext.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = CONTENT_TYPE_HTML_UTF_8

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            FileContext(ChannelHtmlWriter(it, options)).func()
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val func: suspend HtmlContext.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = CONTENT_TYPE_HTML_UTF_8

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlWriter(it, options).apply {
                docType(DocType.Html)
                html {
                    func()
                }
            }
        }
    }
}

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtmlFile(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    func: suspend FileContext.() -> Unit
): Unit = respond(HtmlFileOutgoingContent(status, options, func))

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    func: suspend HtmlContext.() -> Unit
): Unit = respond(HtmlOutgoingContent(status, options, func))

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtmlWriter(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.default,
    func: suspend HtmlWriter.() -> Unit
): Unit = respond(HtmlWriterOutgoingContent(status, options, func))
