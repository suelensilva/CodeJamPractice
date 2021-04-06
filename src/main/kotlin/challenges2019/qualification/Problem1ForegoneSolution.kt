package challenges2019.qualification

import java.math.BigDecimal

fun main(args: Array<String>) {
    val nTests = readLine()!!.toInt()
    for(i in 1..nTests) {
        val n = readLine()!!.toBigDecimal()
        val a = calculateA(n)
        val b = n - a
        println("Case #$i: $a $b")
    }
}

private fun calculateA(n: BigDecimal): BigDecimal {
    var sumA = BigDecimal(0)
    val nStr = n.toString()
    for(i in nStr.length - 1 downTo 0) {
        val d = Character.getNumericValue(nStr[i])
        if(d == 4) {
            sumA += calculateDecimal(nStr.length - 1 - i)
        }
    }
    return sumA
}

private fun calculateDecimal(decimal: Int): BigDecimal {
    var result = "1"
    for(int in 1 .. decimal) {
        result += 0
    }
    return result.toBigDecimal()
}