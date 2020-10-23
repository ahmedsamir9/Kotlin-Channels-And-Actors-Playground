package `Channels Types`

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.runBlocking


fun main()= runBlocking{

    val channel = Channel<Int>(capacity = Channel.UNLIMITED)
    repeat(50){
        println("send $it")
        channel.send(it)
        //delay(100)
    }
    channel.consumeEach {
        println(it)
    }

    coroutineContext.cancelChildren()

}