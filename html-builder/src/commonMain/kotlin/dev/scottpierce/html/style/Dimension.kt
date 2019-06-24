package dev.scottpierce.html.style

sealed class Dimension {
    class Size(val value: Float, val unit: Unit) : Dimension() {
        override fun toString(): String {
            return "$value$unit"
        }
    }

    object Auto : Dimension() {
        override fun toString(): String {
            return "auto"
        }
    }
}

enum class Unit(private val value: String) {
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
  get() = Dimension.Size(toFloat(), Unit.PX)

val Int.em: Dimension
    get() = Dimension.Size(toFloat(), Unit.EM)

val Int.ex: Dimension
    get() = Dimension.Size(toFloat(), Unit.EX)

val Int.percent: Dimension
    get() = Dimension.Size(toFloat(), Unit.PERCENT)

val Int.rem: Dimension
    get() = Dimension.Size(toFloat(), Unit.REM)

val Float.px: Dimension
    get() = Dimension.Size(this, Unit.PX)

val Float.em: Dimension
    get() = Dimension.Size(this, Unit.EM)

val Float.ex: Dimension
    get() = Dimension.Size(this, Unit.EX)

val Float.percent: Dimension
    get() = Dimension.Size(this, Unit.PERCENT)

val Float.rem: Dimension
    get() = Dimension.Size(this, Unit.REM)

val Double.px: Dimension
    get() = Dimension.Size(toFloat(), Unit.PX)

val Double.em: Dimension
    get() = Dimension.Size(toFloat(), Unit.EM)

val Double.ex: Dimension
    get() = Dimension.Size(toFloat(), Unit.EX)

val Double.percent: Dimension
    get() = Dimension.Size(toFloat(), Unit.PERCENT)

val Double.rem: Dimension
    get() = Dimension.Size(toFloat(), Unit.REM)
