package dev.scottpierce.html.style

val Style.marginX: Dimension?
    get() = properties["margin-left"] as Dimension?

var StyleBuilder.marginX: Dimension?
    get() = properties["margin-left"] as Dimension?
    set(value) {
        properties["margin-left"] = value
        properties["margin-right"] = value
    }

val Style.marginY: Dimension?
    get() = properties["margin-top"] as Dimension?

var StyleBuilder.marginY: Dimension?
    get() = properties["margin-top"] as Dimension?
    set(value) {
        properties["margin-top"] = value
        properties["margin-bottom"] = value
    }

val Style.paddingX: Dimension?
    get() = properties["padding-left"] as Dimension?

var StyleBuilder.paddingX: Dimension?
    get() = properties["padding-left"] as Dimension?
    set(value) {
        properties["padding-left"] = value
        properties["padding-right"] = value
    }

val Style.paddingY: Dimension?
    get() = properties["padding-top"] as Dimension?

var StyleBuilder.paddingY: Dimension?
    get() = properties["padding-top"] as Dimension?
    set(value) {
        properties["padding-top"] = value
        properties["padding-bottom"] = value
    }
