import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main()= runBlocking{
    val channel = fruits()
    val fliterColor =fliterColor(channel)
    val finalFruit = fliterFurit(fliterColor)

    finalFruit.consumeEach {
        println( "final $it")
    }
    coroutineContext.cancelChildren()
}
data class Fruit(val name : String, val color: String ){
    override fun toString(): String {
        return name
    }
}
suspend fun fruits()= GlobalScope.produce<Fruit> {
    val list = listOf<Fruit>(Fruit("ba","Y"),Fruit("Cu","R"),Fruit("St","R"))
    for (fruit in list){
        println("send$fruit")
        send(fruit)
    }
}
suspend fun fliterColor(channel: ReceiveChannel<Fruit>):ReceiveChannel<Fruit> = GlobalScope.produce {
    for ( fruit in channel){
        if (fruit.color.equals("R")) {
            println("col $fruit")
            send(fruit)
        }
    }
}
suspend fun fliterFurit(channel: ReceiveChannel<Fruit>):ReceiveChannel<Fruit> = GlobalScope.produce {
    for ( furit in channel){
        if (furit.name.equals("St")) {
            println("fruit $furit")
            send(furit)
        }
    }
}
