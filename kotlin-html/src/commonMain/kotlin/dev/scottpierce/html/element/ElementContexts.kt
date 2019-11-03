// This file was generated using the `html-builder-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.element

import dev.scottpierce.html.style.StyleSheet
import dev.scottpierce.html.style.writeStyleSheet
import dev.scottpierce.html.write.HtmlWriter

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface Context {
    val writer: HtmlWriter

    /**
     * Inline a [StyleSheet] into the current location.
     */
    @HtmlDsl
    operator fun StyleSheet.unaryPlus() {
        this@Context.writer.writeStyleSheet(this)
    }
}

interface HasText : Context {
    operator fun String.unaryPlus() {
        writer.newLine()
        writer.write(this)
    }
}

@HtmlDsl
inline class FileContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class HtmlContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class HeadContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class ScriptContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class BodyContext(override val writer: HtmlWriter) : Context, HasText

@HtmlDsl
inline class SelectContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class UlContext(override val writer: HtmlWriter) : Context

@HtmlDsl
inline class VideoContext(override val writer: HtmlWriter) : Context
