package challenges2021.qualification

import kotlin.math.min

var x = 0
var y = 0
var costs = HashMap<String, Int>()

fun main(args: Array<String>) {
    val t = readInt()

    for(i in 1..t) {
        val (xStr, yStr, S) = readStrings()
        x = xStr.toInt()
        y = yStr.toInt()
        costs.clear()

        val minCost = minimumCost(S)

        println("Case #$i: $minCost")
    }
}

fun minimumCost(s: String): Int {
    if(s.length == 1) return 0

    costs[s]?.let {
        return it
    }

    var minWithC = 0
    var minWithJ = 0
    var filledGaps = s
    val firstGap = s.indexOfFirst { c -> c == '?' }

    if(firstGap > -1) {
        filledGaps = s.substring(0, firstGap)

        var extraCCost = 0
        var extraJCost = 0

        if(filledGaps.isNotEmpty()) {
            val lastLetter = filledGaps[filledGaps.length - 1]
            extraCCost = if (lastLetter == 'J') y else 0
            extraJCost = if (lastLetter == 'C') x else 0
        }

        val substring = s.substring(firstGap + 1)

        minWithC = minimumCost("C$substring") + extraCCost

        minWithJ = minimumCost("J$substring") + extraJCost
    }

    val cost = stringCost(filledGaps) + min(minWithC, minWithJ)

    costs[s] = cost

    return cost
}

fun stringCost(s: String): Int {
    if(s.length <= 1) return 0
    return (countMatches(s, "CJ") * x) + (countMatches(s, "JC") * y)
}

fun countMatches(string: String, pattern: String): Int {
    return string.windowed(pattern.length) {
        if (it == pattern)
            1
        else
            0
    }.sum()
}


private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }.toTypedArray()