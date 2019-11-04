package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.div
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeFile
import kotlin.test.Test
import kotlin.test.assertTrue

class AttributeTest {
    @Test
    fun singleAttribute() {
        writeFile {
            html {
                head(id = "head")
                body(id = "body") {
                    div(id = "div")
                }
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
            writeFile {
                html {
                    head("foo bar" to "test")
                }
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
            writeFile {
                html {
                    head("" to "test")
                }
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
            writeFile {
                html {
                    head("   " to "test")
                }
            }
            false
        } catch (t: IllegalArgumentException) {
            true
        }

        assertTrue(errorThrown)
    }

    @Test
    fun multipleAttributes() {
        writeFile {
            html {
                head("test1" to "value1", id = "head")
                body("test2" to "value2", id = "body") {
                    div("test3" to "value3", "test4" to "value4", id = "div")
                }
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

    @Test
    fun multipleListAttributes() {
        writeFile {
            html {
                head(listOf("test1" to "value1"), id = "head")
                body(listOf("test2" to "value2"), id = "body") {
                    div(listOf("test3" to "value3", "test4" to "value4"), id = "div")
                }
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
