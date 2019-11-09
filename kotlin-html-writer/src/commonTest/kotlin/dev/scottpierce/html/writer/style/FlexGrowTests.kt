package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyle
import kotlin.test.Test

class FlexGrowTests {
    @Test
    fun basic() {
        writeStyle {
            flexGrow(1)
        } assertEquals {
            "flex-grow: 1;"
        }
    }

    @Test
    fun inherit() {
        writeStyle {
            flexGrow(CssValue.INHERIT)
        } assertEquals {
            "flex-grow: inherit;"
        }
    }

    @Test
    fun initial() {
        writeStyle {
            flexGrow(CssValue.INITIAL)
        } assertEquals {
            "flex-grow: initial;"
        }
    }
}
