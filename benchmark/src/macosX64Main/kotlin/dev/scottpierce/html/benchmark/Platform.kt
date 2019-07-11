package dev.scottpierce.html.benchmark

actual object Platform {
    actual val currentTime: Long
        get() = kotlin.system.getTimeMillis()
}
