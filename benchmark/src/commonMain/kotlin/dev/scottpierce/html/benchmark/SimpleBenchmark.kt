package dev.scottpierce.html.benchmark

import dev.scottpierce.html.write.*

val innerLoopSize = 20_000


object SimpleBenchmark {
    fun run(print: Boolean) {
        val results = mutableListOf<Long>()

        val benchmarkStart = Platform.currentTime

        repeat(50) {
            var count = 0

            val startTime = Platform.currentTime

            // Build a simple website 20,000 times
            for (i in 0 until innerLoopSize) {
                val result = kotlinHtmlPage(StringBuilderHtmlWriter(options = WriteOptions.minified))
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

/**
 * simplest possible measurement of the construction costs where the compiler can short-circuit everything except the test itself
 */
object NullBenchmark {
    fun run(print: Boolean) {
        println("Null benchmark start")
        val results = mutableListOf<Long>()

        val benchmarkStart = Platform.currentTime

        repeat(50) {
            var count = 0

            val startTime = Platform.currentTime

            // Build a simple website 20,000 times
            for (i in 0 until innerLoopSize) count += kotlinHtmlPage(NullHtmlWriter(options = WriteOptions.minified)).length

            val benchmarkTime = Platform.currentTime - startTime
            results += benchmarkTime

            if (print) println("Iteration Took $benchmarkTime millis. Count: $count")
        }

        val benchmarkTotalMillis = Platform.currentTime - benchmarkStart

        if (print) println("Null Benchmark Completed. Benchmark Total Millis: $benchmarkTotalMillis, Average iteration was ${results.average()} millis")
    }
}

/**
 * simple benchmark to isolate the construction costs and "IO" costs discretely and possibly
 * increase inner-loop locality of reference
 */
object DeferredBenchmark {
    fun run(print: Boolean) {
        println("DeferredBenchmark start")
        val results = mutableListOf<Long>()

        val benchmarkStart = Platform.currentTime
        repeat(50) {
            val creationcostresults = Array<Long>(innerLoopSize, { 0 })
            val reifycostresults = Array<Long>(innerLoopSize, { 0 })
            var count = 0
//            val writers: MutableList<DeferredHtmlWriter> = mutableListOf()

            val startTime = Platform.currentTime

            // Build a simple website 20,000 times
            (0 until innerLoopSize).forEach { i ->
                val creation = Platform.currentTime

                //we really want to defer these all until the last timer evaluation but linux_x64 clearly runs up a
                // huge heap cost for this test if we store 20k of these in a list
                val htmlWriter =
                    DeferredHtmlWriter(StringBuilderHtmlWriter(options = WriteOptions.minified))
                val result = kotlinHtmlPage(htmlWriter)

                val creationDone = Platform.currentTime

                htmlWriter.reify()

                reifycostresults[i] = Platform.currentTime - creationDone
                creationcostresults[i] = creationDone - creation

                count += result.length
            }

            var benchmarkTime = Platform.currentTime - startTime
            results += benchmarkTime

//            writers.forEach { it.reify() }
            if (print) {
                val c: Double = creationcostresults.sum().toDouble()
                val r: Double = reifycostresults.sum().toDouble()
                if (print) println("Iteration Took $benchmarkTime millis. Count: $count; Creation $c; Reify $r; r/c = ${r / c}")
            }

        }

        val finalTime = Platform.currentTime
        val benchmarkTotalMillis = finalTime - benchmarkStart
        if (print) {
            val average = results.average()
            println("Deferred Benchmark Total Millis: $benchmarkTotalMillis, Average iteration was $average millis ")
//            val avgcreation = creationcostresults.average()
//            val avgreify = reifycostresults.average()
//            println("creation/reaify split: create: ${avgcreation} reify: ${reifycostresults} ratio ${avgreify / avgcreation} = r/c   ")
        }


    }
}

object ThreeBenchmarks {
    fun run(print: Boolean) {
        SimpleBenchmark.run(print)
        DeferredBenchmark.run(print)
        NullBenchmark.run(print)
    }
}