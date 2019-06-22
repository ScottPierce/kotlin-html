package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test
import kotlin.test.assertTrue

class AttributeTest {
    @Test
    fun singleAttribute() {
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

    @Test
    fun emptyAttribute() {
        val errorThrown: Boolean = try {
            writeHtml(isDebug = true) {
                head("" by "test")
            }
            false
        } catch (t: IllegalArgumentException) {
            true
        }

        assertTrue(errorThrown)
    }

    @Test
    fun blankAttribute() {
        val errorThrown: Boolean = try {
            writeHtml(isDebug = true) {
                head("   " by "test")
            }
            false
        } catch (t: IllegalArgumentException) {
            true
        }

        assertTrue(errorThrown)
    }

    @Test
    fun multipleAttributes() {
        writeHtml(isDebug = true) {
            head("test1" by "value1", id = "head")
            body("test2" by "value2", id = "body") {
                div("test3" by "value3", "test4" by "value4", id = "div")
            }
        } assertEquals {
            """
            <html>
                <head id="head" test1="value1">
                </head>
                <body id="body" test2="value2">
                    <div id="div" test3="value3" test4="value4">
                    </div>
                </body>
            </html>
            """.trimIndent()
        }
    }
}
