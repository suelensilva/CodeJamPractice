package challenges2019

import kotlin.math.pow

fun main(args: Array<String>) {
    val nTests = readLine()!!.toInt()
    for(i in 1..nTests) {
        val n = readLine()!!.toInt()
        val a = calculateA(n)
        val b = n - a
        println("Case #$i: $a $b")
    }
}

private fun calculateA(n: Int): Int {
    var sumA = 0
    val nStr = n.toString()
    for(i in nStr.length - 1 downTo 0) {
        val d = Character.getNumericValue(nStr[i])
        if(d == 4) {
            sumA += 10.0.pow((nStr.length - 1 - i).toDouble()).toInt()
        }
    }
    return sumA
}