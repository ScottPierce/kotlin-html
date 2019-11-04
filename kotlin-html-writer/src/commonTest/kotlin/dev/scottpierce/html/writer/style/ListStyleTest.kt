package dev.scottpierce.html.writer.style

import kotlin.test.Test
import kotlin.test.assertEquals

class ListStyleTest {
    @Test
    fun write() {
        assertEquals("disc",
            ListStyle(type = ListStyle.Type.DISC).toString())

        assertEquals("disc inside",
            ListStyle(type = ListStyle.Type.DISC, position = ListStyle.Position.INSIDE).toString())

        assertEquals("disc inside inherit",
            ListStyle(
                type = ListStyle.Type.DISC,
                position = ListStyle.Position.INSIDE,
                image = ListStyle.Image.Inherit
            ).toString())
    }
}
