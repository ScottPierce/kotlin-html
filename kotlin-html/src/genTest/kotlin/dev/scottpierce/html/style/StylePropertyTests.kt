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
            background = "boo"
            assertEquals("boo", background)
        }
        assertEquals("boo", style.background)
    }

    @Test
    fun backgroundColor() {
        val style = style {
            backgroundColor = color("#555555")
            assertEquals(color("#555555"), backgroundColor)
        }
        assertEquals(color("#555555"), style.backgroundColor)
    }

    @Test
    fun border() {
        val style = style {
            border = "boo"
            assertEquals("boo", border)
        }
        assertEquals("boo", style.border)
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
            flexDirection = FlexDirection.COLUMN
            assertEquals(FlexDirection.COLUMN, flexDirection)
        }
        assertEquals(FlexDirection.COLUMN, style.flexDirection)
    }

    @Test
    fun fontFamily() {
        val style = style {
            fontFamily = "boo"
            assertEquals("boo", fontFamily)
        }
        assertEquals("boo", style.fontFamily)
    }

    @Test
    fun height() {
        val style = style {
            height = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), height)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.height)
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
    fun listStyle() {
        val style = style {
            listStyle = ListStyle(ListStyle.Type.DISC)
            assertEquals(ListStyle(ListStyle.Type.DISC), listStyle)
        }
        assertEquals(ListStyle(ListStyle.Type.DISC), style.listStyle)
    }

    @Test
    fun outline() {
        val style = style {
            outline = "boo"
            assertEquals("boo", outline)
        }
        assertEquals("boo", style.outline)
    }

    @Test
    fun padding() {
        val style = style {
            padding = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), padding)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.padding)
    }

    @Test
    fun paddingLeft() {
        val style = style {
            paddingLeft = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), paddingLeft)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.paddingLeft)
    }

    @Test
    fun paddingRight() {
        val style = style {
            paddingRight = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), paddingRight)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.paddingRight)
    }

    @Test
    fun paddingTop() {
        val style = style {
            paddingTop = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), paddingTop)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.paddingTop)
    }

    @Test
    fun paddingBottom() {
        val style = style {
            paddingBottom = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), paddingBottom)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.paddingBottom)
    }

    @Test
    fun position() {
        val style = style {
            position = Position.STATIC
            assertEquals(Position.STATIC, position)
        }
        assertEquals(Position.STATIC, style.position)
    }

    @Test
    fun margin() {
        val style = style {
            margin = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), margin)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.margin)
    }

    @Test
    fun marginLeft() {
        val style = style {
            marginLeft = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), marginLeft)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.marginLeft)
    }

    @Test
    fun marginRight() {
        val style = style {
            marginRight = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), marginRight)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.marginRight)
    }

    @Test
    fun marginTop() {
        val style = style {
            marginTop = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), marginTop)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.marginTop)
    }

    @Test
    fun marginBottom() {
        val style = style {
            marginBottom = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), marginBottom)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.marginBottom)
    }

    @Test
    fun width() {
        val style = style {
            width = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), width)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.width)
    }

    @Test
    fun zIndex() {
        val style = style {
            zIndex = 100
            assertEquals(100, zIndex)
        }
        assertEquals(100, style.zIndex)
    }
}
