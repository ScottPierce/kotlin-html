package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.element.body
import dev.scottpierce.html.writer.element.div
import dev.scottpierce.html.writer.element.head
import dev.scottpierce.html.writer.element.html
import dev.scottpierce.html.writer.style.backgroundColor
import kotlin.test.Test

class WriteOnceTests {
    @Test
    fun basic() {
        val phoneId = StyleBuilderId("phone")
        testWriter {
            html {
                head {
                    insertStyleBuilder {
                        media(phoneId, "(width < 400px)")
                    }
                }
                body {
                    style(".example", writeOnce = true) {
                        backgroundColor(0, 0, 0)
                        media(phoneId) {
                            backgroundColor(1, 1, 1)
                        }
                    }

                    style(".example", writeOnce = true) {
                        backgroundColor(2, 2, 2)
                        media(phoneId) {
                            backgroundColor(3, 3, 3)
                        }
                    }

                    div(classes = "example") {
                        +"blah"
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style type="text/css">
                        .example {
                            background-color: rgb(0,0,0);
                        }
                        @media (width < 400px) {
                            .example {
                                background-color: rgb(1,1,1);
                            }
                        }
                    </style>
                </head>
                <body>
                    <div class="example">
                        blah
                    </div>
                </body>
            </html>
            """.trimIndent()
        }
    }
}
