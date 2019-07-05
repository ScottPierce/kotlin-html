package dev.scottpierce.html

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

object HtmlBenchmark {
    fun runBenchmark() {
        // Warmup
        println("Running 2 warm-up passes for kotlin-html")
        benchmark(false) { kotlinHtml().length }
        benchmark(false) { kotlinHtml().length }

        System.gc()
        Thread.sleep(5000)

        // Run Tests
        println("Running Benchmark for kotlin-html")
        benchmark(true) { kotlinHtml().length }

        System.gc()
        Thread.sleep(5000)

        // Warmup
        println("Running 2 warm-up passes for kotlinx.html")
        benchmark(false) { kotlinxHtml().length }
        benchmark(false) { kotlinxHtml().length }

        System.gc()
        Thread.sleep(5000)

        // Run Tests
        println("Running Benchmark for kotlinx.html")
        benchmark(true) { kotlinxHtml().length }
    }

    private fun benchmark(print: Boolean, func: () -> Int) {
        val results = ArrayList<Long>()
        val cores = Runtime.getRuntime().availableProcessors() + 1

        if (print) {
            println("Running benchmark with $cores cores.")
        }

        repeat(10) {
            val executor = Executors.newFixedThreadPool(cores)
            val count = AtomicInteger()

            results += measureTimeMillis {
                for (i in 0 until 100_000) {
                    executor.execute {
                        func()
                    }
                }

                executor.shutdown()
                executor.awaitTermination(1, TimeUnit.MINUTES)
            }

            if (print) {
                println("Benchmark took ${results.last()} millis. Count: ${count.get()}")
            }
        }

        if (print) {
            println("Average: ${results.average()} millis. Length: ${func()}")
        }
    }
}
