import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

suspend fun consumer(channel: ReceiveChannel<Int>, num :Int): ReceiveChannel<Int> = GlobalScope.produce {
    channel.consumeEach {
        println("recevie $num => $it")
    }
}