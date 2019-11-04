package dev.scottpierce.html.writer.style

inline class Dimension(val value: String) {
    companion object {
        val ZERO: Dimension = Dimension("0")
        val AUTO: Dimension = Dimension("auto")
        val INHERIT: Dimension = Dimension("inherit")
    }

    override fun toString(): String = value
}

enum class DimensionUnit(private val value: String) {
    // Relative units
    PX("px"),
    EM("em"),
    EX("ex"),
    PERCENT("%"),
    REM("rem"),

    // Absolute units
    INCH("in"),
    CM("cm"),
    MM("mm"),
    PT("pt"),
    PC("pc"),
    ;

    override fun toString() = value
}

private fun dimension(value: Int, unit: DimensionUnit): Dimension {
    return if (value == 0) {
        Dimension.ZERO
    } else {
        Dimension("$value$unit")
    }
}

private fun dimension(value: Float, unit: DimensionUnit): Dimension {
    return if (value == 0f) {
        Dimension.ZERO
    } else {
        Dimension("$value$unit")
    }
}

private fun dimension(value: Double, unit: DimensionUnit): Dimension {
    return if (value == 0.0) {
        Dimension.ZERO
    } else {
        Dimension("$value$unit")
    }
}

val Int.px: Dimension
    get() = dimension(this, DimensionUnit.PX)

val Int.em: Dimension
    get() = dimension(this, DimensionUnit.EM)

val Int.ex: Dimension
    get() = dimension(this, DimensionUnit.EX)

val Int.percent: Dimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Int.rem: Dimension
    get() = dimension(this, DimensionUnit.REM)

val Float.px: Dimension
    get() = dimension(this, DimensionUnit.PX)

val Float.em: Dimension
    get() = dimension(this, DimensionUnit.EM)

val Float.ex: Dimension
    get() = dimension(this, DimensionUnit.EX)

val Float.percent: Dimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Float.rem: Dimension
    get() = dimension(this, DimensionUnit.REM)

val Double.px: Dimension
    get() = dimension(this, DimensionUnit.PX)

val Double.em: Dimension
    get() = dimension(this, DimensionUnit.EM)

val Double.ex: Dimension
    get() = dimension(this, DimensionUnit.EX)

val Double.percent: Dimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Double.rem: Dimension
    get() = dimension(this, DimensionUnit.REM)
