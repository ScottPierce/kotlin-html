package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter

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
