package challenges2020.qualification

import java.util.*

val scanner = Scanner(System.`in`)
var normal = IntArray(1)
var nBits = 0
var query = 0

fun main(args: Array<String>) {

    val firstInput = readLine()!!.split(" ").map{ it.toInt() }

    val nTests = firstInput[0]
    nBits = firstInput[1]

    normal = IntArray(nBits) { -1 }

    var idEqual = 0
    var idOpposite = 0

    for(t in 1 .. nTests) {
        var i = 1
        val firstHalfIndex = nBits / 2

        while (i <= firstHalfIndex) {
            val ask1 = i
            val ask2 = nBits +1-i

            val pair1 = askNumber(ask1)
            normal[ask1-1] = pair1

            hasRandomFluctuation(idEqual, idOpposite)

            val pair2 = askNumber(ask2)
            normal[ask2-1] = pair2

            if(idEqual == 0 && pair1 == pair2) {
                idEqual = ask1
            }

            if(idOpposite == 0 && pair1 != pair2) {
                idOpposite = ask1
            }

            hasRandomFluctuation(idEqual, idOpposite)

            i++
        }

        normal.forEach { print(it) }
        println()
        System.out.flush()

        val response = scanner.next()

        if (response == "N") break
        else {
            query = 0
            for(n in 0 until nBits) {
                normal[n] = -1
            }
            idEqual = 0
            idOpposite = 0
        }
    }
}

private fun hasRandomFluctuation(
    idEqual: Int,
    idOpposite: Int
) {
    if (query % 10 == 0) {

        if (idEqual > 0 && idOpposite > 0) {

            val currOppositeValue = askNumber(idOpposite)
            val previousOppositeValue = normal[idOpposite - 1]

            val currEqualValue = askNumber(idEqual)
            val previousEqualValue = normal[idEqual - 1]

            if (currOppositeValue != previousOppositeValue) {
                if (currEqualValue != previousEqualValue) {
                    System.err.println("bit flip")
                    complement()
                } else {
                    System.err.println("reverse")
                    reverse()
                }
            } else {
                if (currEqualValue != previousEqualValue) {
                    System.err.println("reverse")
                    System.err.println("bit flip")
                    reverse()
                    complement()
                }
            }
        } else if (idEqual > 0) {

            val currEqualValue = askNumber(idEqual)
            val previousEqualValue = normal[idEqual - 1]

            askNumber(idEqual)

            if (currEqualValue != previousEqualValue) {
                System.err.println("bit flip")
                complement()
            }

        } else if (idOpposite > 0) {

            val currOppositeValue = askNumber(idOpposite)
            val previousOppositeValue = normal[idOpposite - 1]

            askNumber(idOpposite)

            if (currOppositeValue != previousOppositeValue) {
                System.err.println("bit flip")
                complement()
            }
        }
    }
}

private fun askNumber(id: Int): Int {
    println(id)
    System.out.flush()
    query++

    return scanner.nextInt()
}

private fun complement() {
    normal.forEachIndexed { index, v ->
        normal[index] = if (v == 1) 0 else 1
    }
}

private fun reverse() {
    normal.reverse()
}