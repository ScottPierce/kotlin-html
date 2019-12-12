package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.div
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeHtml
import kotlin.test.Test

class HtmlTest {
    @Test
    fun emptyHtmlTest() {
        writeHtml(options = WriteOptions.minified) {
        } assertEquals {
            "<html></html>"
        }
    }

    @Test
    fun docTypeHtmlTest() {
        writeHtml(options = WriteOptions.minified, docType = DocType.Html) {
        } assertEquals {
            """
            <!DOCTYPE html><html></html>
            """.trimIndent()
        }
    }

    @Test
    fun docTypeCustomTest() {
        writeHtml(options = WriteOptions.minified, docType = DocType.Custom("custom")) {
        } assertEquals {
            """
            <!DOCTYPE custom><html></html>
            """.trimIndent()
        }
    }

    @Test
    fun debugTest() {
        writeHtml {
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
