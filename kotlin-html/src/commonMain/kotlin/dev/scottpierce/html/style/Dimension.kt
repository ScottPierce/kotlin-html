package dev.scottpierce.html.style

sealed class Dimension {
    companion object {
        const val ZERO = "0"
    }

    data class Size(val value: Float, val unit: DimensionUnit) : Dimension() {
        override fun toString(): String = if (value == 0f) ZERO else "$value$unit"
    }

    object Auto : Dimension() {
        override fun toString(): String = "auto"
    }
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

val Int.px: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.PX)

val Int.em: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.EM)

val Int.ex: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.EX)

val Int.percent: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.PERCENT)

val Int.rem: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.REM)

val Float.px: Dimension
    get() = Dimension.Size(this, DimensionUnit.PX)

val Float.em: Dimension
    get() = Dimension.Size(this, DimensionUnit.EM)

val Float.ex: Dimension
    get() = Dimension.Size(this, DimensionUnit.EX)

val Float.percent: Dimension
    get() = Dimension.Size(this, DimensionUnit.PERCENT)

val Float.rem: Dimension
    get() = Dimension.Size(this, DimensionUnit.REM)

val Double.px: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.PX)

val Double.em: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.EM)

val Double.ex: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.EX)

val Double.percent: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.PERCENT)

val Double.rem: Dimension
    get() = Dimension.Size(toFloat(), DimensionUnit.REM)
