package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.util.assertEquals
import dev.scottpierce.html.writer.util.writeStyle
import kotlin.test.Test
import kotlin.test.assertEquals

class ListStyleTest {
    @Test
    fun write() {
        writeStyle {
            listStyle(ListStyleType.DISC)
        } assertEquals {
            """list-style: disc;"""
        }

        writeStyle {
            listStyle(ListStyleType.DISC, ListStylePosition.INSIDE)
        } assertEquals {
            """list-style: disc inside;"""
        }

        writeStyle {
            listStyle(ListStyleType.DISC, ListStylePosition.INSIDE, ListStyleImage.INHERIT)
        } assertEquals {
            """list-style: disc inside inherit;"""
        }
    }
}
