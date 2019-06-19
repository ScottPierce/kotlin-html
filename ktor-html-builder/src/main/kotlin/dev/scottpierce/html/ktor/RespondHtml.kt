package dev.scottpierce.html.ktor

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
suspend fun ApplicationCall.respondHtml(status: HttpStatusCode = HttpStatusCode.OK, block: Html.() -> Unit) {
    respond(HtmlContent(status, block))
}

/**
 * Represents an [OutgoingContent] using `kotlinx.html` builder.
 */
class HtmlContent(
    override val status: HttpStatusCode? = null,
    private val builder: Html.() -> Unit
) : OutgoingContent.WriteChannelContent() {
    override val contentType: ContentType
        get() = ContentType.Text.Html.withCharset(Charsets.UTF_8)

    override suspend fun writeTo(channel: ByteWriteChannel) {
        channel.bufferedWriter().use {
            // it.append("<!DOCTYPE html>\n")
            // it.appendHtml().html(block = builder)
            val writer = ChannelHtmlWriter(it)
            val html = Html().apply(builder)
            html.write(writer)
        }
    }
}