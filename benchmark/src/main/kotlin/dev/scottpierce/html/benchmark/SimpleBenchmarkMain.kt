package dev.scottpierce.html.benchmark

object SimpleBenchmarkMain {
    @JvmStatic
    fun main(args: Array<String>) {
        // Warm-up
        SimpleBenchmark.run(false)
        SimpleBenchmark.run(false)

        // Run
        SimpleBenchmark.run(true)
    }
}

