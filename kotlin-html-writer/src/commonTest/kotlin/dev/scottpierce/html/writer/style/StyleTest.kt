package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyle
import dev.scottpierce.html.writer.WriteOptions
import kotlin.test.Test

class StyleTest {
    @Test
    fun basic() {
        writeStyle {
            marginX = 10.px
        } assertEquals {
            """
                margin-left: 10px;
                margin-right: 10px;
            """.trimIndent()
        }
    }

    @Test
    fun basicMinified() {
        writeStyle(options = WriteOptions(minifyStyles = true)) {
            marginX = 10.px
        } assertEquals {
            """
                margin-left:10px;
                margin-right:10px;
            """.trimIndent()
        }
    }
}
