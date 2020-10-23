package Channels

import consumer
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach

fun main()= runBlocking{
//size = 0
   val channel = Channel<Int>(capacity = Channel.RENDEZVOUS)
    val con = consumer(channel, 1)
    repeat(5){
        println("send $it")
        channel.send(it)
        delay(100)
    }


   coroutineContext.cancelChildren()

}
