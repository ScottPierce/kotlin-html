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
    fun alignSelf() {
        val style = style {
            alignSelf = AlignSelf.AUTO
            assertEquals(AlignSelf.AUTO, alignSelf)
        }
        assertEquals(AlignSelf.AUTO, style.alignSelf)
    }

    @Test
    fun animationName() {
        val style = style {
            animationName = "boo"
            assertEquals("boo", animationName)
        }
        assertEquals("boo", style.animationName)
    }

    @Test
    fun animationDuration() {
        val style = style {
            animationDuration = "boo"
            assertEquals("boo", animationDuration)
        }
        assertEquals("boo", style.animationDuration)
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
    fun bottom() {
        val style = style {
            bottom = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), bottom)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.bottom)
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
    fun flex() {
        val style = style {
            flex = "boo"
            assertEquals("boo", flex)
        }
        assertEquals("boo", style.flex)
    }

    @Test
    fun flexGrow() {
        val style = style {
            flexGrow = "boo"
            assertEquals("boo", flexGrow)
        }
        assertEquals("boo", style.flexGrow)
    }

    @Test
    fun flexShrink() {
        val style = style {
            flexShrink = "boo"
            assertEquals("boo", flexShrink)
        }
        assertEquals("boo", style.flexShrink)
    }

    @Test
    fun flexBasis() {
        val style = style {
            flexBasis = "boo"
            assertEquals("boo", flexBasis)
        }
        assertEquals("boo", style.flexBasis)
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
    fun float() {
        val style = style {
            float = FloatDirection.LEFT
            assertEquals(FloatDirection.LEFT, float)
        }
        assertEquals(FloatDirection.LEFT, style.float)
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
    fun gridColumnGap() {
        val style = style {
            gridColumnGap = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), gridColumnGap)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.gridColumnGap)
    }

    @Test
    fun gridRowGap() {
        val style = style {
            gridRowGap = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), gridRowGap)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.gridRowGap)
    }

    @Test
    fun gridTemplateColumns() {
        val style = style {
            gridTemplateColumns = "boo"
            assertEquals("boo", gridTemplateColumns)
        }
        assertEquals("boo", style.gridTemplateColumns)
    }

    @Test
    fun gridTemplateRows() {
        val style = style {
            gridTemplateRows = "boo"
            assertEquals("boo", gridTemplateRows)
        }
        assertEquals("boo", style.gridTemplateRows)
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
    fun justifySelf() {
        val style = style {
            justifySelf = JustifyContent.CENTER
            assertEquals(JustifyContent.CENTER, justifySelf)
        }
        assertEquals(JustifyContent.CENTER, style.justifySelf)
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
    fun left() {
        val style = style {
            left = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), left)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.left)
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
    fun maxHeight() {
        val style = style {
            maxHeight = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), maxHeight)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.maxHeight)
    }

    @Test
    fun maxWidth() {
        val style = style {
            maxWidth = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), maxWidth)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.maxWidth)
    }

    @Test
    fun minHeight() {
        val style = style {
            minHeight = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), minHeight)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.minHeight)
    }

    @Test
    fun minWidth() {
        val style = style {
            minWidth = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), minWidth)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.minWidth)
    }

    @Test
    fun right() {
        val style = style {
            right = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), right)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.right)
    }

    @Test
    fun textDecoration() {
        val style = style {
            textDecoration = "boo"
            assertEquals("boo", textDecoration)
        }
        assertEquals("boo", style.textDecoration)
    }

    @Test
    fun textTransform() {
        val style = style {
            textTransform = TextTransform.NONE
            assertEquals(TextTransform.NONE, textTransform)
        }
        assertEquals(TextTransform.NONE, style.textTransform)
    }

    @Test
    fun top() {
        val style = style {
            top = Dimension.Size(1f, DimensionUnit.PX)
            assertEquals(Dimension.Size(1f, DimensionUnit.PX), top)
        }
        assertEquals(Dimension.Size(1f, DimensionUnit.PX), style.top)
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
