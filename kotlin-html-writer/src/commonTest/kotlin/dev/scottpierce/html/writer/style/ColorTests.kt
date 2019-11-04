package dev.scottpierce.html.writer.style

import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTests {
    @Test
    fun twoDigitHexTest() {
        assertEquals("01", 1.twoDigitHex())
        assertEquals("02", 2.twoDigitHex())
        assertEquals("03", 3.twoDigitHex())
        assertEquals("04", 4.twoDigitHex())
        assertEquals("05", 5.twoDigitHex())
        assertEquals("06", 6.twoDigitHex())
        assertEquals("07", 7.twoDigitHex())
        assertEquals("08", 8.twoDigitHex())
        assertEquals("09", 9.twoDigitHex())
        assertEquals("0A", 10.twoDigitHex())
        assertEquals("0B", 11.twoDigitHex())
        assertEquals("0C", 12.twoDigitHex())
        assertEquals("0D", 13.twoDigitHex())
        assertEquals("0E", 14.twoDigitHex())
        assertEquals("0F", 15.twoDigitHex())
        assertEquals("10", 16.twoDigitHex())
        assertEquals("11", 17.twoDigitHex())
        assertEquals("12", 18.twoDigitHex())
        assertEquals("13", 19.twoDigitHex())
        assertEquals("14", 20.twoDigitHex())
        assertEquals("15", 21.twoDigitHex())
        assertEquals("16", 22.twoDigitHex())
        assertEquals("17", 23.twoDigitHex())
        assertEquals("18", 24.twoDigitHex())
        assertEquals("19", 25.twoDigitHex())
        assertEquals("1A", 26.twoDigitHex())
        assertEquals("1B", 27.twoDigitHex())
        assertEquals("1C", 28.twoDigitHex())
        assertEquals("1D", 29.twoDigitHex())
        assertEquals("1E", 30.twoDigitHex())
        assertEquals("1F", 31.twoDigitHex())

        assertEquals("FA", 250.twoDigitHex())
        assertEquals("FB", 251.twoDigitHex())
        assertEquals("FC", 252.twoDigitHex())
        assertEquals("FD", 253.twoDigitHex())
        assertEquals("FE", 254.twoDigitHex())
        assertEquals("FF", 255.twoDigitHex())
    }
}
