package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyle
import kotlin.test.Test

class LineHeightTests {
    @Test
    fun multiplier() {
        writeStyle {
            lineHeight = LineHeight.multiplier(2)
        } assertEquals {
            """line-height: 2;"""
        }
    }

    @Test
    fun dimension() {
        writeStyle {
            lineHeight = 2.px
        } assertEquals {
            """line-height: 2px;"""
        }
    }
}
