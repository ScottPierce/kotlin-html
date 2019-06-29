package dev.scottpierce.html.generate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

fun main() {
    val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    val latch = CountDownLatch(2)

    executor.execute {
        generateElements()
        latch.countDown()
    }

    executor.execute {
        generateElementTests()
        latch.countDown()
    }

    latch.await()
    executor.shutdownNow()
}
