package dev.scottpierce.html.writer

internal actual object PlatformWriter {
    actual val lineSeparator: String
        get() = System.lineSeparator()
}
