package challenges2020

import java.lang.StringBuilder

fun main(args: Array<String>) {

    val firstInput = readLine()!!.split(" ").map{ it.toInt() }

    val nTests = firstInput[0]
    val nBits = firstInput[1]

    val response = StringBuilder("")

    for(i in 1..nBits) {
        println(i)
        val nextBit = readLine()!!
        response.append(nextBit)
    }
    println(response.toString())
}