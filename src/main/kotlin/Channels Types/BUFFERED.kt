package Channels

import consumer
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow

fun main()= runBlocking{

    val channel = Channel<Int>(capacity = 10)
    val con = consumer(channel,1)
    repeat(15){
        println("send $it")
        channel.send(it)
        
    }

    channel.cancel()
}


