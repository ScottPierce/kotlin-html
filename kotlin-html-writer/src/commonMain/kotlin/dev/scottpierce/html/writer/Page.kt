package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.HtmlDsl
import dev.scottpierce.html.writer.element.HtmlWriterContext

/**
 * Creates a [Page], and handles it's lifecycle.
 *
 * A [Page] should only be accessed inside of the given lambda, and shouldn't be saved for later.
 */
@HtmlDsl
inline fun pageWriterScope(htmlWriter: HtmlWriter, func: Page.() -> Unit) {
    InternalApi.closePage(
        InternalApi.Page(htmlWriter).apply(func)
    )
}

class Page internal constructor(private val primaryWriter: HtmlWriter) {
    val options: WriteOptions = primaryWriter.options
    private var indent = 0
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    private var currentWriter: HtmlWriter = primaryWriter

    private var bufferedSegments: MutableList<BufferedPageSegment>? = null
    private var isClosed = false

    private var _state: MutableMap<String, Any>? = null

    val state: MutableMap<String, Any>
        get() = _state ?: run {
            val state = HashMap<String, Any>(8)
            _state = state
            state
        }

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

    internal fun <T : HtmlWriterContext> defer(context: T, write: T.() -> Unit) {
        // TODO defer inside of defer won't work
        val bufferedSegments: MutableList<BufferedPageSegment> = bufferedSegments
            ?: ArrayList<BufferedPageSegment>(4).also { bufferedSegments = it }

        bufferedSegments += BufferedPageSegment.Deferred(context, write, indent)

        val newWriter = StringBuilderHtmlWriter()
        bufferedSegments += BufferedPageSegment.Written(newWriter)
        currentWriter = newWriter
    }

    internal fun close() {
        if (isClosed) return

        currentWriter = primaryWriter

        bufferedSegments?.let { bufferedSegments ->
            for (bufferedSegment in bufferedSegments) {
                when (bufferedSegment) {
                    is BufferedPageSegment.Deferred<*> -> {
                        indent = bufferedSegment.indent
                        bufferedSegment.performWrite()
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

@HtmlDsl
fun <T : HtmlWriterContext> T.defer(write: T.() -> Unit) = page.defer(this, write)

private sealed class BufferedPageSegment {
    class Deferred<T : HtmlWriterContext>(
        val context: T,
        val write: T.() -> Unit,
        val indent: Int
    ) : BufferedPageSegment() {
        fun performWrite() {
            context.write()
        }
    }
    class Written(val writer: StringBuilderHtmlWriter) : BufferedPageSegment()
}
