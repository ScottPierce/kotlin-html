package dev.scottpierce.html.writer.style

inline class Dimension(val value: String) {
    companion object {
        val ZERO: Dimension = Dimension("0")
        val AUTO: Dimension = Dimension("auto")
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

val Int.px: Dimension
    get() = Dimension("$this${DimensionUnit.PX}")

val Int.em: Dimension
    get() = Dimension("$this${DimensionUnit.EM}")

val Int.ex: Dimension
    get() = Dimension("$this${DimensionUnit.EX}")

val Int.percent: Dimension
    get() = Dimension("$this${DimensionUnit.PERCENT}")

val Int.rem: Dimension
    get() = Dimension("$this${DimensionUnit.REM}")

val Float.px: Dimension
    get() = Dimension("$this${DimensionUnit.PX}")

val Float.em: Dimension
    get() = Dimension("$this${DimensionUnit.EM}")

val Float.ex: Dimension
    get() = Dimension("$this${DimensionUnit.EX}")

val Float.percent: Dimension
    get() = Dimension("$this${DimensionUnit.PERCENT}")

val Float.rem: Dimension
    get() = Dimension("$this${DimensionUnit.REM}")

val Double.px: Dimension
    get() = Dimension("$this${DimensionUnit.PX}")

val Double.em: Dimension
    get() = Dimension("$this${DimensionUnit.EM}")

val Double.ex: Dimension
    get() = Dimension("$this${DimensionUnit.EX}")

val Double.percent: Dimension
    get() = Dimension("$this${DimensionUnit.PERCENT}")

val Double.rem: Dimension
    get() = Dimension("$this${DimensionUnit.REM}")
