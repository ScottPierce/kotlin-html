@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

import dev.scottpierce.html.element.DocType
import dev.scottpierce.html.element.FileContext
import dev.scottpierce.html.element.HtmlContext
import dev.scottpierce.html.element.docType
import dev.scottpierce.html.element.html
import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.write.WriteOptions
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.withCharset
import io.ktor.response.respond
import io.ktor.util.cio.bufferedWriter
import kotlinx.coroutines.io.ByteWriteChannel

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlWriterOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val func: HtmlWriter.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlWriter(it, options).apply(func)
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlFileOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val func: FileContext.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            FileContext(ChannelHtmlWriter(it, options)).apply(func)
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`
 */
class HtmlOutgoingContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val func: HtmlContext.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

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
    options: WriteOptions = WriteOptions.minified,
    func: FileContext.() -> Unit
): Unit = respond(HtmlFileOutgoingContent(status, options, func))

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.minified,
    func: HtmlContext.() -> Unit
): Unit = respond(HtmlOutgoingContent(status, options, func))

/**
 * Responds to a client with a HTML response, using specified [func] to build an HTML page
 */
suspend fun ApplicationCall.respondHtmlWriter(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.minified,
    func: HtmlWriter.() -> Unit
): Unit = respond(HtmlWriterOutgoingContent(status, options, func))
