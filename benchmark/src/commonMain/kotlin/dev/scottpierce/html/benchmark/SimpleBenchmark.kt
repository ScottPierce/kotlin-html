package dev.scottpierce.html.benchmark

object SimpleBenchmark {
    fun run(print: Boolean) {
        val results = mutableListOf<Long>()

        val benchmarkStart = Platform.currentTime

        repeat(50) {
            var count = 0

            val startTime = Platform.currentTime

            for (i in 0 until 20_000) {
                val result = kotlinHtml()
                count += result.length
            }

            val benchmarkTime = Platform.currentTime - startTime
            results += benchmarkTime

            if (print) {
                println("Iteration Took $benchmarkTime millis. Count: $count")
            }
        }

        val benchmarkTotalMillis = Platform.currentTime - benchmarkStart

        if (print) {
            println("Benchmark Completed. Benchmark Total Millis: $benchmarkTotalMillis, Average iteration was ${results.average()} millis")
        }
    }
}
