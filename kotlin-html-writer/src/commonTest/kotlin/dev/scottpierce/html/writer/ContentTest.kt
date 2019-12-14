package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.br
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.write
import kotlin.test.Test

class ContentTest {
    @Test
    fun basic() {
        write {
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
        write {
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
