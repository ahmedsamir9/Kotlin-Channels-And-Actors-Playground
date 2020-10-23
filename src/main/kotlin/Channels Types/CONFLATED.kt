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
//size = -1
    val channel = Channel<Int>(capacity = Channel.CONFLATED)
    val con = consumer(channel,1)

    repeat(5){
        println("send $it")
        channel.send(it)
        delay(100)
    }
    channel.consumeEach {
    println("recevie  => $it")
    }
    channel.cancel()
}

