package dev.scottpierce.html.ktor

import dev.scottpierce.html.element.HtmlContext
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode

suspend fun <TTemplate : Template<HtmlContext>> ApplicationCall.respondHtmlTemplate(
    template: TTemplate,
    status: HttpStatusCode = HttpStatusCode.OK,
    body: TTemplate.() -> Unit
) {
    template.body()
    respondHtml(status) { template.apply(body) }
}
