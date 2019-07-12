package dev.scottpierce.html.write

import dev.scottpierce.html.element.HtmlDsl
import dev.scottpierce.html.element.a

@HtmlDsl
interface HtmlWriter {
    val options: WriteOptions
    val isEmpty: Boolean

    fun write(c: Char): HtmlWriter
    fun write(code: CharSequence): HtmlWriter
    fun newLine(): HtmlWriter
    fun indent()
    fun deindent()
}

abstract class AbstractHtmlWriter(final override val options: WriteOptions) : HtmlWriter {
    var indent = 0
    val indentString = options.indent.takeUnless(String::isEmpty)
    val newLineString   = options.newLine.takeUnless(String::isEmpty)

    final override var isEmpty: Boolean = true
        set

    final override fun newLine() = apply {
        newLineString?.run {
            write(newLineString)
        }
        indentString?.run {
            (1..indent).forEach {
                write(indentString)
            }
        }
    }

    final override fun indent() = let {
        indent++
        Unit
    }

    final override fun deindent() = let {
        indent--
        Unit
    }

    final override fun write(c: Char) = apply {
        this.isEmpty = false
        writeChar(c)
    }

    final override fun write(code: CharSequence) = apply {
        isEmpty = false
        writeCharSequence(code)
    }

    abstract fun writeChar(c: Char)
    abstract fun writeCharSequence(code: CharSequence)
}

class StringBuilderHtmlWriter(
    initialCapacity: Int = 128,
    options: WriteOptions = WriteOptions.default
) : AbstractHtmlWriter(options) {
    private val sb = StringBuilder(initialCapacity)

    override fun writeChar(c: Char) {
        sb.append(c)
    }

    override fun writeCharSequence(code: CharSequence) {
        sb.append(code)
    }

    override fun toString(): String = sb.toString()
}

/**
 *
 * baseline Writer to measure pre-writer performance overheads and compare to sb HtmlWriter
 *
 * HtmlWriter with a performance-only goal of producing none of:
 *  * array operations
 *  * context switches
 *  * page faults
 *  * buffer operations
 */
class NullHtmlWriter(
    options: WriteOptions = WriteOptions.default
) : AbstractHtmlWriter(options) {

    override fun writeChar(c: Char) {}
    override fun writeCharSequence(code: CharSequence) {}
    override fun toString() = ""
}

/**
 * this builds a list of lambda instances and awaits reify() whereupon these deferredTask are executed
 */
class DeferredHtmlWriter(
    val delegate: HtmlWriter,
    var deferredTask: MutableCollection<() -> Any?> = mutableListOf(),
    override val isEmpty: Boolean = delegate.isEmpty, override val options: WriteOptions = delegate.options
) : HtmlWriter {

    override fun write(c: Char): HtmlWriter = apply { deferredTask.add { delegate.write(c) } }

    override fun write(code: CharSequence): HtmlWriter = apply {
        deferredTask.add { delegate.write(code) }
    }

    override fun newLine(): HtmlWriter = apply {
        deferredTask.add(delegate::newLine)
    }

    override fun indent() {
        deferredTask.add(delegate::indent)

    }

    override fun deindent() {
        deferredTask.add(delegate::deindent)

    }

    /**
     * destructive operation to execute the queue of tasks and clear it to avoid any unintended consequences of reuse.
     */
    fun reify() = deferredTask.forEach { it() }.also { deferredTask.clear() }
}


data class WriteOptions(
    val indent: String = "\t",
    val newLine: String = "\n",
    val minifyStyles: Boolean = false
) {
    companion object {
        val default = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "", minifyStyles = true)
    }
}
