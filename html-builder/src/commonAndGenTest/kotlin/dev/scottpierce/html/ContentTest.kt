package dev.scottpierce.html

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeHtml
import kotlin.test.Test

class ContentTest {
    @Test
    fun basic() {
        writeHtml {
            body {
                +""
            }
        }.assertEquals {
            """
                <
            """.trimIndent()
        }
    }
}