import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.isFrozen
import kotlin.random.Random

fun main() {
    val context1: CoroutineContext = newSingleThreadContext("Context1")

    runBlocking(context1) {
        println("Example 1")

        val example1 = Example1(context1)

        example1.example1()
        example1.example1()
        example1.example1()

        println("Data Value: ${example1.data.value}")
        println("Is MutableData Frozen : ${example1.data.isFrozen}")
        println("Is Example1 Frozen: ${example1.isFrozen}")
    }
}

object Background {
    val context: CoroutineContext = newSingleThreadContext("Background") + NonCancellable

    suspend fun asyncRandomInt(): Int = withContext(context) {
        5
    }
}

data class MutableData(
    var value: Int
)

class Example1(val context: CoroutineContext) {
    val data = MutableData(0)

    suspend fun example1() = withContext(context) {
        val randomValue = Background.asyncRandomInt()
        data.value += randomValue
    }
}

