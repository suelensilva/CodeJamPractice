package challenges2021.qualification

import kotlin.math.min

var array = Array(0) { 0 }

fun main(args: Array<String>) {
    val t = readInt()

    for(i in 1..t) {
        val (n, c) = readInts()

        array = Array(n) { it + 1 }

        val minCost = n - 1
        val maxCost = (n downTo 2).sum()

        if(c < minCost || c > maxCost) {
            println("Case #$i: IMPOSSIBLE")
            continue
        }

        scrumble(c)

        print("Case #$i: ")
        array.forEach { print("$it ") }
        println()
    }
}

private fun scrumble(cost: Int) {
    var remainingCost = cost
    for(i in array.size-2 downTo 0) {
        val availableCost = remainingCost - i
        val maxSwapSize = array.size - i

        val swapSize = min(maxSwapSize, availableCost)
        val swapIndex = i + swapSize - 1

        if(i != swapIndex) {
            array.reverse(i, swapIndex+1)
        }

        remainingCost -= swapSize
    }
}

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }.toTypedArray()
