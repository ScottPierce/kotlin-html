package dev.scottpierce.html

import dev.scottpierce.html.element.DocType
import dev.scottpierce.html.element.body
import dev.scottpierce.html.element.div
import dev.scottpierce.html.element.head
import dev.scottpierce.html.element.html
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class HtmlTest {
    @Test
    fun emptyHtmlTest() {
        writeHtml(options = WriteOptions.minified) {
            html()
        } assertEquals {
            "<html></html>"
        }
    }

    @Test
    fun docTypeHtmlTest() {
        writeHtml(options = WriteOptions.minified) {
            html(docType = DocType.Html)
        } assertEquals {
            """
            <!DOCTYPE html>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun docTypeCustomTest() {
        writeHtml(options = WriteOptions.minified) {
            html(docType = DocType.Custom("custom"))
        } assertEquals {
            """
            <!DOCTYPE custom>
            <html></html>
            """.trimIndent()
        }
    }

    @Test
    fun debugTest() {
        writeHtml {
            html {
            }
        } assertEquals {
            """
            <html>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun debugWithChildTest() {
        writeHtml {
            html {
                head()
                body {
                    div()
                }
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
