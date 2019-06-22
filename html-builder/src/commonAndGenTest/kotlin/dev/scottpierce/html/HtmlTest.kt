package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test

class HtmlTest {
    @Test
    fun emptyHtmlTest() {
        writeHtml(options = WriteOptions.minified).assertEquals("<html></html>")
    }

    @Test
    fun docTypeHtmlTest() {
        writeHtml(docType = DocType.Html, options = WriteOptions.minified).assertEquals {
            """
            <!DOCTYPE html>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun docTypeCustomTest() {
        writeHtml(docType = DocType.Custom("custom"), options = WriteOptions.minified).assertEquals {
            """
            <!DOCTYPE custom>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun debugTest() {
        writeHtml().assertEquals {
            """
            <html>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun debugWithChildTest() {
        writeHtml {
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
