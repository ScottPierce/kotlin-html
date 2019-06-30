@file:Suppress("EXPERIMENTAL_API_USAGE")

package dev.scottpierce.html.ktor

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
 * Responds to a client with a HTML response, using specified [block] to build an HTML page
 */
suspend fun ApplicationCall.respondHtml(
    status: HttpStatusCode = HttpStatusCode.OK,
    options: WriteOptions = WriteOptions.minified,
    block: HtmlWriter.() -> Unit
) {
    respond(HtmlContent(status, options, block))
}

/**
 * Represents an [OutgoingContent] using `dev.scottpierce.html` builder.
 */
class HtmlContent(
    override val status: HttpStatusCode? = null,
    private val options: WriteOptions,
    private val builder: HtmlWriter.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            ChannelHtmlWriter(it, options).apply(builder)
        }
    }
}
