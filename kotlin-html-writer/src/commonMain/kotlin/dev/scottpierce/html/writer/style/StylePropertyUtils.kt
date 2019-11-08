package dev.scottpierce.html.writer.style

import kotlin.time.Duration

fun Duration.toCssString(): String {
    val seconds = this.inSeconds
    val secondsInt = seconds.toInt()
    return if (seconds == secondsInt.toDouble()) {
        "${seconds.toInt()}s"
    } else {
        "${toLongMilliseconds()}ms"
    }
}
