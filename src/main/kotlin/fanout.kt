import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

fun main()= runBlocking {
    val producer = produceNewNumbers()
    repeat(5) { launchProcessor(it, producer) }
    delay(1500L)
    producer.cancel()
}
fun CoroutineScope.produceNewNumbers() = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) =
    launch {
        for (message in channel)
            println("Processor $id received $message")
    }


