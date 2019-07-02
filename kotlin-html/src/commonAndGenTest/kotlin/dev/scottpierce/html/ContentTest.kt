package dev.scottpierce.html

import dev.scottpierce.html.element.body
import dev.scottpierce.html.element.br
import dev.scottpierce.html.element.html
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeFile
import kotlin.test.Test

class ContentTest {
    @Test
    fun basic() {
        writeFile {
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
        writeFile {
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
