package dev.scottpierce.html.style

import dev.scottpierce.html.util.assertEquals
import dev.scottpierce.html.util.writeStyle
import dev.scottpierce.html.write.WriteOptions
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
