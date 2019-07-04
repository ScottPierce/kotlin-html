// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.style

import kotlin.test.Test
import kotlin.test.assertEquals

class StylePropertyTests {
    @Test
    fun alignItems() {
        val style = style {
            alignItems = AlignItems.BASELINE
            assertEquals(AlignItems.BASELINE, alignItems)
        }
        assertEquals(AlignItems.BASELINE, style.alignItems)
    }

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
    fun flexDirection() {
        val style = style {
            flexDirection = AlignItems.BASELINE
            assertEquals(AlignItems.BASELINE, flexDirection)
        }
        assertEquals(AlignItems.BASELINE, style.flexDirection)
    }

    @Test
    fun justifyContent() {
        val style = style {
            justifyContent = JustifyContent.CENTER
            assertEquals(JustifyContent.CENTER, justifyContent)
        }
        assertEquals(JustifyContent.CENTER, style.justifyContent)
    }

    @Test
    fun padding() {
        val style = style {
            padding = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, padding)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.padding)
    }

    @Test
    fun paddingLeft() {
        val style = style {
            paddingLeft = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, paddingLeft)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.paddingLeft)
    }

    @Test
    fun paddingRight() {
        val style = style {
            paddingRight = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, paddingRight)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.paddingRight)
    }

    @Test
    fun paddingTop() {
        val style = style {
            paddingTop = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, paddingTop)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.paddingTop)
    }

    @Test
    fun paddingBottom() {
        val style = style {
            paddingBottom = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, paddingBottom)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.paddingBottom)
    }

    @Test
    fun margin() {
        val style = style {
            margin = Dimension.Size(1f, DimensionUnit.PX
            assertEquals(Dimension.Size(1f, DimensionUnit.PX, margin)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX, style.margin)
    }
}
