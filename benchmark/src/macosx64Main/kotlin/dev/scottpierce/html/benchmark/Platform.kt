package dev.scottpierce.html.benchmark

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual object Platform {
    actual val currentTime: Long
        get() = (NSDate().timeIntervalSince1970 * 1000).toLong()
}
