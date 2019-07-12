// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.StyleSheetBuilder
import dev.scottpierce.html.write.HtmlWriter
import dev.scottpierce.html.style.StyleSheet

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface Context {
    val writer: HtmlWriter
}

interface HasText : Context {
    operator fun String.unaryPlus() {
        writer.newLine()
        writer.write(this)
    }
}

@HtmlDsl
class FileContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class HtmlContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class HeadContext(override val writer: HtmlWriter) : Context {
    /**
     * Creates a [StyleSheet] and writes it to the current `head` element.
     *
     * This function is on the [HeadContext] explicitly instead of as an extension function to prevent the confusion
     * of creating a [StyleSheet] and having it not be written due to importing the wrong extension function.
     */
    @HtmlDsl
    inline fun styleSheet(func: StyleSheetBuilder.() -> Unit = {}) {
        val builder = StyleSheetBuilder().apply(func)
        this.styleSheet(builder)
    }
}

@HtmlDsl
class ScriptContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class BodyContext(override val writer: HtmlWriter) : Context, HasText

@HtmlDsl
class SelectContext(override val writer: HtmlWriter) : Context

@HtmlDsl
class UlContext(override val writer: HtmlWriter) : Context
