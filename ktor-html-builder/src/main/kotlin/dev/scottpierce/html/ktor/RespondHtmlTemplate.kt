package dev.scottpierce.html.ktor

import dev.scottpierce.html.Html
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode

suspend fun <TTemplate : Template<Html>> ApplicationCall.respondHtmlTemplate(
    template: TTemplate,
    status: HttpStatusCode = HttpStatusCode.OK,
    body: TTemplate.() -> Unit
) {
    template.body()
    respondHtml(status) { with(template) { apply() } }
}
