package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test
import kotlin.test.assertTrue

class AttributeTest {
    @Test
    fun basic() {
        writeHtml(isDebug = true) {
            head(id = "head")
            body(id = "body") {
                div(id = "div")
            }
        } assertEquals {
            """
            <html>
                <head id="head">
                </head>
                <body id="body">
                    <div id="div">
                    </div>
                </body>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun noWhitespaceInAttributes() {
        val errorThrown: Boolean = try {
            writeHtml(isDebug = true) {
                head("foo bar" by "test")
            }
            false
        } catch (t: IllegalArgumentException) {
            true
        }

        assertTrue(errorThrown)
    }
}
