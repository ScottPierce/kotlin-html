package dev.scottpierce.html.writer

/**
 * Creates a [Page], and handles it's lifecycle.
 *
 * A [Page] should only be accessed inside of the given lambda, and shouldn't be saved for later.
 */
inline fun pageWriterScope(htmlWriter: HtmlWriter, func: Page.() -> Unit) {
    InternalApi.closePage(
        InternalApi.Page(htmlWriter).apply(func)
    )
}

class Page internal constructor(private val primaryWriter: HtmlWriter) {
    private var indent = 0
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    private var _currentWriter: HtmlWriter? = primaryWriter
    private val currentWriter: HtmlWriter
        get() {
            val currentWriter = _currentWriter
            return if (currentWriter == null) {
                val newWriter = StringBuilderHtmlWriter()
                bufferedSegments!! += BufferedPageSegment.Written(newWriter)
                newWriter
            } else {
                currentWriter
            }
        }

    private var bufferedSegments: MutableList<BufferedPageSegment>? = null
    private var isClosed = false

    private var _state: MutableMap<String, Any>? = null

    val state: MutableMap<String, Any>
        get() = _state ?: run {
            val state = HashMap<String, Any>(8)
            _state = state
            state
        }

    val options: WriteOptions
        get() = primaryWriter.options

    var isEmpty: Boolean = true
        private set

    fun newLine(): Page {
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

    fun write(c: Char): Page {
        throwIfClosed()
        isEmpty = false

        currentWriter.write(c)
        return this
    }

    fun write(code: String): Page {
        throwIfClosed()
        isEmpty = false
        currentWriter.write(code)
        return this
    }

    fun defer(write: Page.() -> Unit) {
        val bufferedSegments: MutableList<BufferedPageSegment> = bufferedSegments
            ?: ArrayList<BufferedPageSegment>(2).also { bufferedSegments = it }

        bufferedSegments += BufferedPageSegment.Deferred(write)
        _currentWriter = null
    }

    internal fun close() {
        if (isClosed) return

        _currentWriter = primaryWriter

        bufferedSegments?.let { bufferedSegments ->
            for (bufferedSegment in bufferedSegments) {
                when (bufferedSegment) {
                    is BufferedPageSegment.Deferred -> {
                        val write = bufferedSegment.write
                        write()
                    }
                    is BufferedPageSegment.Written -> {
                        primaryWriter.write(bufferedSegment.writer.asCharSequence())
                    }
                }
            }
        }

        isClosed = true
    }

    private fun throwIfClosed() {
        check(!isClosed) { "PageWriter is closed, and can no longer be used." }
    }
}

private sealed class BufferedPageSegment {
    class Deferred(val write: Page.() -> Unit) : BufferedPageSegment()
    class Written(val writer: StringBuilderHtmlWriter) : BufferedPageSegment()
}
