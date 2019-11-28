@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext

fun BaseStyleContext.marginX(value: Dimension) {
    marginLeft(value)
    marginRight(value)
}

fun BaseStyleContext.marginY(value: Dimension) {
    marginTop(value)
    marginBottom(value)
}

fun BaseStyleContext.paddingX(value: Dimension) {
    paddingLeft(value)
    paddingRight(value)
}

fun BaseStyleContext.paddingY(value: Dimension) {
    paddingTop(value)
    paddingBottom(value)
}
