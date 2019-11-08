@file:Suppress("FunctionName")

package dev.scottpierce.html.writer.style

interface BoxShadow {
    companion object {
        val NONE: BoxShadow = BoxShadowString("none")
        val INITIAL: BoxShadow = BoxShadowString("initial")
        val INHERIT: BoxShadow = BoxShadowString("inherit")
    }
}

private inline class BoxShadowString(val styleString: String) : BoxShadow {
    override fun toString(): String = styleString
}

fun BoxShadow(
    hOffset: Number,
    vOffset: Number,
    color: Color,
    inset: Boolean = false
): BoxShadow = BoxShadowString("$hOffset $vOffset $color${if (inset) " inset" else ""}")

fun BoxShadow(
    hOffset: Number,
    vOffset: Number,
    color: Color,
    blur: Number,
    spread: Number? = null,
    inset: Boolean = false
): BoxShadow {
    return BoxShadowString(
        "$hOffset $vOffset $color $blur" +
                if (spread == null) "" else " $spread" +
                        if (inset) " inset" else ""
    )
}
