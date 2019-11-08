package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyleSheet
import kotlin.test.Test

class MediaQueryTest {
    @Test
    fun basic() {
        writeStyleSheet {
            media("(max-width: 300px)") {
                style(".test") {
                    display(Display.NONE)
                }
            }
        } assertEquals {
            """
            <style type="text/css">
                @media (max-width: 300px) {
                    .test {
                        display: none;
                    }
                }
            </style>
            """.trimIndent()
        }
    }
}
