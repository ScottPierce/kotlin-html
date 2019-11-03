package dev.scottpierce.html

import dev.scottpierce.html.element.head
import dev.scottpierce.html.element.html
import dev.scottpierce.html.style.style
import dev.scottpierce.html.style.styleSheet
import dev.scottpierce.html.style.writeStyleProperty
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeFile
import kotlin.test.Test

class HeaderStyleTest {
    @Test
    fun emptyStyleSheet() {
        writeFile {
            html {
                head {
                    styleSheet {
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style type="text/css">
                    </style>
                </head>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun simpleStyleSheet() {
        writeFile {
            html {
                head {
                    styleSheet {
                        style(".example-class") {
                            writeStyleProperty("example-property", "example-value")
                        }
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style type="text/css">
                        .example-class {
                            example-property: example-value;
                        }
                    </style>
                </head>
            </html>
            """.trimIndent()
        }
    }

    @Test
    fun dualStyles() {
        writeFile {
            html {
                head {
                    styleSheet {
                        style(".example-class") {
                            writeStyleProperty("example-property", "example-value")
                            writeStyleProperty("example-property2", "example-value2")
                        }

                        style(".example-class2") {
                            writeStyleProperty("example-property3", "example-value3")
                            writeStyleProperty("example-property4", "example-value4")
                        }
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style type="text/css">
                        .example-class {
                            example-property: example-value;
                            example-property2: example-value2;
                        }
                        .example-class2 {
                            example-property3: example-value3;
                            example-property4: example-value4;
                        }
                    </style>
                </head>
            </html>
            """.trimIndent()
        }
    }
}
