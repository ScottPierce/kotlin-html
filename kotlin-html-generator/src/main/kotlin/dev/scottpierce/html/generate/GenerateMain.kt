package dev.scottpierce.html.generate

import dev.scottpierce.html.generate.task.GenerateElementTestsTask
import dev.scottpierce.html.generate.task.GenerateElementsTask
import dev.scottpierce.html.generate.task.GenerateStylePropertiesTask
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // Generation tasks
    val tasks: List<Task> = listOf(
        GenerateElementsTask(),
        GenerateElementTestsTask(),
        GenerateStylePropertiesTask()
    )

    val job = GlobalScope.launch {
        // Run the actual tasks
        for (task in tasks) {
            launch {
                println("Starting Task: ${task.name}")
                val millis = measureTimeMillis {
                    task.execute()
                }
                println("Completed Task: ${task.name}, took $millis millis.")
            }
        }
    }

    // Await until all tasks are done and then exit the process
    runBlocking {
        job.join()
    }
}

interface Task {
    val name: String
    suspend fun execute()
}
