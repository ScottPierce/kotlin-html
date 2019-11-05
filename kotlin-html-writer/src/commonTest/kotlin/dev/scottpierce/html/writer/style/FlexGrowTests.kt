package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyle
import kotlin.test.Test

class FlexGrowTests {
    @Test
    fun basic() {
        writeStyle {
            flexGrow = 1.0
        } assertEquals {
            "flex-grow: 1.0;"
        }
    }

    @Test
    fun inherit() {
        writeStyle {
            flexGrow = FlexGrow.INHERIT
        } assertEquals {
            "flex-grow: inherit;"
        }
    }

    @Test
    fun initial() {
        writeStyle {
            flexGrow = FlexGrow.INITIAL
        } assertEquals {
            "flex-grow: initial;"
        }
    }
}
