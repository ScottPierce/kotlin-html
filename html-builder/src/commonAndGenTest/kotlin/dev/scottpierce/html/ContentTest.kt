package dev.scottpierce.html

import dev.scottpierce.html.element.body
import dev.scottpierce.html.element.br
import dev.scottpierce.html.element.html
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test

class ContentTest {
    @Test
    fun basic() {
        writeHtml {
            html {
                body {
                    +"Test"
                }
            }
        } assertEquals {
            """
            <html>
                <body>
                    Test
                </body>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun brTest() {
        writeHtml {
            html {
                body {
                    br()
                }
            }
        } assertEquals {
            """
            <html>
                <body>
                    <br>
                </body>
            </html>
            """.trimIndent()
        }
    }
}
