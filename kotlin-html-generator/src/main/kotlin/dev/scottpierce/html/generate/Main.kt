package dev.scottpierce.html.generate

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun main() {
    val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()) {
        Thread(it).apply {
            // Set all the threads as daemons so that the program can exit when all work is complete
            isDaemon = true
        }
    }

    // Generation tasks
    val tasks: List<Task> = listOf(
        Task("Generate Elements") { generateElements() },
        Task("Generate Element Tests") { generateElementTests() },
        Task("Generate Style Properties") { generateStyleProperties() }
    )

    // When this latch completes, all generation tasks are done
    val latch = CountDownLatch(tasks.size)

    // Run the actual tasks
    for (task in tasks) {
        executor.execute {
            println("Starting Task: ${task.name}")
            val millis = measureTimeMillis {
                task.execute()
            }
            println("Completed Task: ${task.name}, took $millis millis.")
            latch.countDown()
        }
    }

    // Await until all tasks are done and then exit the process
    latch.await()
}

data class Task(
    val name: String,
    val execute: () -> Unit
)
