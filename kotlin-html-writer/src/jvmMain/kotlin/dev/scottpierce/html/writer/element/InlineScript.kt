package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlWriter
import java.io.File

fun HtmlWriter.inlineScript(
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(async = async, defer = defer) {
        inlineFile(file)
    }
}

fun HtmlWriter.inlineScript(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = *attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}

fun HtmlWriter.inlineScript(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    script(attrs = attrs, async = async, defer = defer) {
        inlineFile(file)
    }
}

fun Context.inlineScript(
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    writer.inlineScript(async = async, defer = defer, file = file)
}

fun Context.inlineScript(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    writer.inlineScript(attrs = *attrs, async = async, defer = defer, file = file)
}

fun Context.inlineScript(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    file: File
) {
    writer.inlineScript(attrs = attrs, async = async, defer = defer, file = file)
}
