package dev.scottpierce.html.writer

import kotlin.jvm.Volatile

/**
 * Creates a [HtmlWriter], and handles it's lifecycle.
 *
 * A [HtmlWriter] should only be accessed inside of the given lambda, and shouldn't be saved for later.
 */
inline fun HtmlOutput.writer(func: HtmlWriter.() -> Unit): HtmlWriter {
    return HtmlWriter(this).apply {
        func()
        close()
    }
}

class HtmlWriter internal constructor(
    private val output: HtmlOutput,
    private var indent: Int
) {
    constructor(
        output: HtmlOutput
    ) : this(output, 0)

    val options = output.options
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    private var currentOutput: HtmlOutput = output

    private var childOutputs: MutableList<StringHtmlOutput?>? = null
    private var isClosed = false

    private var childWriters: MutableMap<String, HtmlWriter>? = null

    var isEmpty: Boolean = true
        private set

    fun close() {
        if (isClosed) return
        isClosed = true

        childWriters?.forEach { it.value.close() }

        // Allow writers and outputs to be GC as they are written
        childWriters = null
        currentOutput = output

        childOutputs?.let { childOutputs ->
            for (i in childOutputs.indices) {
                val output = childOutputs[i]!!
                output.write(output.charSequence)
                childOutputs[i] = null // Free for GC
            }
        }
    }

    fun insertWriter(name: String): HtmlWriter {
        val childWriters = childWriters ?: HashMap<String, HtmlWriter>(8).also { childWriters = it }

        val writer = HtmlWriter(
            output = StringHtmlOutput(options = options),
            indent = indent
        )

        val previous = childWriters.put(name, writer)
        check(previous == null) { "A writer with the name '$name' has already been inserted." }

        return writer
    }

    fun writer(name: String): HtmlWriter {
        return childWriters?.get(name)
            ?: throw IllegalArgumentException("Writer '$name' was retrieved before it was inserted.")
    }

    fun newLine(): HtmlWriter {
        if (newLineString != null) {
            write(newLineString)
        }

        if (indentString != null) {
            for (i in 1..indent) {
                write(indentString)
            }
        }

        return this
    }

    fun indent() {
        indent++
    }

    fun unindent() {
        indent--
    }

    fun write(c: Char): HtmlWriter {
        throwIfClosed()
        isEmpty = false

        currentOutput.write(c)
        return this
    }

    fun write(code: String): HtmlWriter {
        throwIfClosed()
        isEmpty = false
        currentOutput.write(code)
        return this
    }

    private fun throwIfClosed() {
        check(!isClosed) { "PageWriter is closed, and can no longer be used." }
    }
}

inline fun <T : HtmlWriterContext> T.insertWriter(name: String, func: T.() -> Unit = {}) {
    val insertedWriter = writer.insertWriter(name)
    @Suppress("UNCHECKED_CAST")
    (withWriter(insertedWriter) as T).func()
}

data class WriteOptions(
    val indent: String = "  ",
    val newLine: String = PlatformWriter.lineSeparator,
    val minifyStyles: Boolean = false
) {
    companion object {
        val readable = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "", minifyStyles = true)

        // TODO use atomicfu for Kotlin/native
        @Volatile
        var default = minified
    }
}
