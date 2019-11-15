import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    println("Starting")

    var dataUsedInCoroutine = MutableData(1)

    val job1 = GlobalScope.launch {
        dataUsedInCoroutine = MutableData(2)
    }

    println("Job Created")

    runBlocking {
        job1.join()
    }

    newSingleThreadContext("")

    println("Joined")
    println(dataUsedInCoroutine.value)
    println("Finished")
}

data class MutableData(
    var value: Int
)
