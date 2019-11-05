package dev.scottpierce.html.writer.style

interface LineHeight {
    companion object {
        val NORMAL: LineHeight = StringLineHeight("normal")
        val INITIAL: LineHeight = StringLineHeight("initial")
        val INHERIT: LineHeight = StringLineHeight("inherit")

        fun multiplier(multiplier: Int): LineHeight = StringLineHeight(multiplier.toString())
        fun multiplier(multiplier: Float): LineHeight = StringLineHeight(multiplier.toString())
        fun multiplier(multiplier: Double): LineHeight = StringLineHeight(multiplier.toString())
    }
}

private inline class StringLineHeight(val value: String) : LineHeight {
    override fun toString(): String = value
}
