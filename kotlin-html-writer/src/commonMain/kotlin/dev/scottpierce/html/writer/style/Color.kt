@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package dev.scottpierce.html.writer.style

fun color(red: Int, green: Int, blue: Int, alpha: Float = 1f): Color =
    Color(red = red, green = green, blue = blue, alpha = alpha)

fun color(hexString: String): Color = Color(hexString)

inline class Color(val hexString: String) {
    companion object {
        fun toHexString(red: Int, green: Int, blue: Int, alpha: Float = 1f): String {
            val hexR = red.twoDigitHex()
            val hexG = green.twoDigitHex()
            val hexB = blue.twoDigitHex()
            val hexA = if (alpha == 1f) null else (alpha * (255 + 0.5f)).toInt().twoDigitHex()

            return "#$hexR$hexG$hexB${hexA.orEmpty()}"
        }

        private fun String.toHex(): String = this

        val WHITE = Color("#ffffff")
        val BLACK = Color("#000000")
        val INHERIT = Color("inherit")
    }

    constructor(red: Int, green: Int, blue: Int, alpha: Float = 1f) :
            this(toHexString(red = red, green = green, blue = blue, alpha = alpha))

    override fun toString() = hexString.toHex()
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
