package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test

class HtmlTest {
    @Test
    fun emptyHtmlTest() {
        writeHtml().assertEquals("<html></html>")
    }

    @Test
    fun docTypeHtmlTest() {
        writeHtml(docType = DocType.Html).assertEquals {
            """
            <!DOCTYPE html>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun docTypeCustomTest() {
        writeHtml(docType = DocType.Custom("custom")).assertEquals {
            """
            <!DOCTYPE custom>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun debugTest() {
        writeHtml(isDebug = true).assertEquals {
            """
            <html>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun debugWithChildTest() {
        writeHtml(isDebug = true) {
            head()
            body {
                div()
            }
        } assertEquals {
            """
            <html>
                <head>
                </head>
                <body>
                    <div>
                    </div>
                </body>
            </html>
            """.trimIndent()
        }
    }
}
