@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.writer.style

class Color private constructor(val colorString: String, notUsed: Boolean) {
    companion object {
        fun toHexString(red: Int, green: Int, blue: Int, alpha: Float = 1f): String {
            val hexR = red.twoDigitHex()
            val hexG = green.twoDigitHex()
            val hexB = blue.twoDigitHex()
            val hexA = if (alpha == 1f) null else (alpha * (255 + 0.5f)).toInt().twoDigitHex()

            return "#$hexR$hexG$hexB${hexA.orEmpty()}"
        }

        internal fun colorString(r: Int, g: Int, b: Int): String = "rgb($r,$g,$b)"
        internal fun colorString(r: Int, g: Int, b: Int, a: Number): String = "rgba($r,$g,$b,$a)"
        internal fun colorString(hexString: String): String =
            if (hexString.first() == '#') hexString else "#$hexString"

        val WHITE = Color("#ffffff", false)
        val BLACK = Color("#000000", false)
        val TRANSPARENT = Color("transparent", false)
        val INHERIT = Color("inherit", false)
        val INITIAL = Color("initial", false)
    }

    constructor(r: Int, g: Int, b: Int) : this(colorString(r, g, b), false)
    constructor(r: Int, g: Int, b: Int, a: Number) : this(colorString(r, g, b, a), false)
    constructor(hexString: String) : this(colorString(hexString), false)

    override fun toString() = colorString
}

internal fun Int.twoDigitHex(): String {
    val firstDigit: Char = (this and 0b1111).toChar()
    val secondDigit: Char = (this and 0b11110000).shr(4).toChar()

    return "${secondDigit.encodedHexToChar()}${firstDigit.encodedHexToChar()}"
}

private fun Char.encodedHexToChar(): Char = when (this) {
    0x0.toChar() -> '0'
    0x1.toChar() -> '1'
    0x2.toChar() -> '2'
    0x3.toChar() -> '3'
    0x4.toChar() -> '4'
    0x5.toChar() -> '5'
    0x6.toChar() -> '6'
    0x7.toChar() -> '7'
    0x8.toChar() -> '8'
    0x9.toChar() -> '9'
    0xA.toChar() -> 'A'
    0xB.toChar() -> 'B'
    0xC.toChar() -> 'C'
    0xD.toChar() -> 'D'
    0xE.toChar() -> 'E'
    0xF.toChar() -> 'F'
    else -> throw UnsupportedOperationException()
}
