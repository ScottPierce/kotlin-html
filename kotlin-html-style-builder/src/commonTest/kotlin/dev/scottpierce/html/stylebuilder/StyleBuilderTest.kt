package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.insertWriter
import dev.scottpierce.html.writer.style.backgroundColor
import dev.scottpierce.html.writer.style.media
import dev.scottpierce.html.writer.style.styleSheet
import kotlin.test.Test

class StyleBuilderTest {
    @Test
    fun basic() {
        testWriter {
            html {
                head {
                    styleSheet {
                        insertWriter(StyleBuilder.NORMAL.writerId)

                        media("(width < 400px)") {
                            insertWriter("phone")
                        }
                    }
                }
                body {
                    style("body") {
                        backgroundColor(0, 0, 0)

                        media("phone") {
                            backgroundColor(255, 255, 255)
                        }
                    }

                    +"Blam"
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style type="text/css">
                        body {
                            background-color: rgb(0,0,0);
                        }
                        @media (width < 400px) {
                            body {
                                background-color: rgb(255,255,255);
                            }
                        }
                    </style>
                </head>
                <body>
                    Blam
                </body>
            </html>
            """.trimIndent()
        }
    }
}
