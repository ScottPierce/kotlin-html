@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

import dev.scottpierce.html.DocType
import dev.scottpierce.html.Html
import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.OutgoingContent
import io.ktor.http.withCharset
import io.ktor.response.respond
import io.ktor.util.cio.bufferedWriter
import kotlinx.coroutines.io.ByteWriteChannel

/**
 * Responds to a client with a HTML response, using specified [block] to build an HTML page
 */
suspend fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    docType: DocType,
    block: Html.() -> Unit
) {
    respond(DynamicHtmlContent(status, docType, block))
}

/**
 * Responds to a client with a HTML response, using the given [html]
 */
suspend fun ApplicationCall.respondHtml(status: HttpStatusCode = HttpStatusCode.OK, html: Html) {
    respond(StaticHtmlContent(status, html))
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html` builder.
 */
class DynamicHtmlContent(
    override val status: HttpStatusCode? = null,
    private val docType: DocType,
    private val builder: Html.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            val writer = ChannelHtmlWriter(it)
            val html = Html(docType = docType).apply(builder)
            html.write(writer)
        }
    }
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html`.
 */
class StaticHtmlContent(
    override val status: HttpStatusCode? = null,
    private val html: Html
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            val writer = ChannelHtmlWriter(it)
            html.write(writer)
        }
    }
}
