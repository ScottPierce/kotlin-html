package dev.scottpierce.html.style

import kotlin.jvm.JvmSynthetic

@get:JvmSynthetic
var BaseStyleContext.marginX: Dimension
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        val valueString = value.toString()
        writeStyleProperty("margin-left", valueString)
        writeStyleProperty("margin-right", valueString)
    }

@get:JvmSynthetic
var BaseStyleContext.marginY: Dimension
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        val valueString = value.toString()
        writeStyleProperty("margin-top", valueString)
        writeStyleProperty("margin-bottom", valueString)
    }

@get:JvmSynthetic
var BaseStyleContext.paddingX: Dimension
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        val valueString = value.toString()
        writeStyleProperty("padding-left", valueString)
        writeStyleProperty("padding-right", valueString)
    }

@get:JvmSynthetic
var BaseStyleContext.paddingY: Dimension
    @Deprecated("", level = DeprecationLevel.ERROR)
    get() = throw UnsupportedOperationException()
    set(value) {
        val valueString = value.toString()
        writeStyleProperty("padding-top", valueString)
        writeStyleProperty("padding-bottom", valueString)
    }
