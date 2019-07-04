// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.style

import kotlin.test.Test
import kotlin.test.assertEquals

class StylePropertyTests {
    @Test
    fun background() {
        val style = style {
            background = color("#555555")
            assertEquals(color("#555555"), background)
        }
        assertEquals(color("#555555"), style.background)
    }

    @Test
    fun color() {
        val style = style {
            color = color("#555555")
            assertEquals(color("#555555"), color)
        }
        assertEquals(color("#555555"), style.color)
    }

    @Test
    fun display() {
        val style = style {
            display = Display.BLOCK
            assertEquals(Display.BLOCK, display)
        }
        assertEquals(Display.BLOCK, style.display)
    }

    @Test
    fun alignItems() {
        val style = style {
            alignItems = AlignItems.BASELINE
            assertEquals(AlignItems.BASELINE, alignItems)
        }
        assertEquals(AlignItems.BASELINE, style.alignItems)
    }

    @Test
    fun flexDirection() {
        val style = style {
            flexDirection = AlignItems.BASELINE
            assertEquals(AlignItems.BASELINE, flexDirection)
        }
        assertEquals(AlignItems.BASELINE, style.flexDirection)
    }
}
