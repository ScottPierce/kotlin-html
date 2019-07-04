package dev.scottpierce.html

import dev.scottpierce.html.element.DocType
import dev.scottpierce.html.element.body
import dev.scottpierce.html.element.div
import dev.scottpierce.html.element.docType
import dev.scottpierce.html.element.head
import dev.scottpierce.html.element.html
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeFile
import dev.scottpierce.html.write.WriteOptions
import kotlin.test.Test

class HtmlTest {
    @Test
    fun emptyHtmlTest() {
        writeFile(options = WriteOptions.minified) {
            html()
        } assertEquals {
            "<html></html>"
        }
    }

    @Test
    fun docTypeHtmlTest() {
        writeFile(options = WriteOptions.minified) {
            docType(DocType.Html)
            html()
        } assertEquals {
            """
            <!DOCTYPE html><html></html>
            """.trimIndent()
        }
    }

    @Test
    fun docTypeCustomTest() {
        writeFile(options = WriteOptions.minified) {
            docType(DocType.Custom("custom"))
            html()
        } assertEquals {
            """
            <!DOCTYPE custom><html></html>
            """.trimIndent()
        }
    }

    @Test
    fun debugTest() {
        writeFile {
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
        writeFile {
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
