package dev.scottpierce.html.writer

actual typealias Closeable = java.io.Closeable

fun test(closeable: Closeable) {
    closeable.use {  }
}
