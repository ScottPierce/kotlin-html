package dev.scottpierce.html.benchmark

fun main() {
    // Warm-up
    SimpleBenchmark.run(false)
    SimpleBenchmark.run(false)

    // Run
    SimpleBenchmark.run(true)
}
