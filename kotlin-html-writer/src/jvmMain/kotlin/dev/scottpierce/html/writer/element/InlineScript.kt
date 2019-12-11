package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlOutput
import java.io.File

fun HtmlOutput.inlineScript(
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(async = async, defer = defer) {
        inlineFile(file)
    }
}

fun HtmlOutput.inlineScript(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = *attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}

fun HtmlOutput.inlineScript(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}

fun BaseHtmlContext.inlineScript(
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(async = async, defer = defer) {
        inlineFile(file)
    }
}

fun BaseHtmlContext.inlineScript(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = *attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}

fun BaseHtmlContext.inlineScript(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}
