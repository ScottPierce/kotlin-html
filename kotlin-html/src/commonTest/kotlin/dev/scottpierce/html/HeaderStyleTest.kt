package dev.scottpierce.html

import dev.scottpierce.html.element.head
import dev.scottpierce.html.element.html
import dev.scottpierce.html.style.styleSheet
import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeFile
import kotlin.test.Test

class HeaderStyleTest {
    @Test
    fun emptyStyleSheet() {
        writeFile {
            html {
                head {
                    +styleSheet()
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style>
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
                    +styleSheet {
                        style(".example-class") {
                            properties["example-property"] = "example-value"
                        }
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style>
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
                    +styleSheet {
                        style(".example-class") {
                            properties["example-property"] = "example-value"
                            properties["example-property2"] = "example-value2"
                        }

                        style(".example-class2") {
                            properties["example-property3"] = "example-value3"
                            properties["example-property4"] = "example-value4"
                        }
                    }
                }
            }
        } assertEquals {
            """
            <html>
                <head>
                    <style>
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
