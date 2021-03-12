package challenges2020

fun main(args: Array<String>) {

    val firstInput = readLine()!!.split(" ").map{ it.toInt() }

    val nTests = firstInput[0]
    val nBits = firstInput[1]

    val normal = IntArray(nBits) { -1 }

    var idxEqual1 = -1
    var idxOpposite1 = -1

    for(t in 1 .. nTests) {

        var i = 1
        var query = 0
        val firstHalfIndex = nBits / 2

        while (i <= firstHalfIndex) {
            val ask1 = i
            val ask2 = nBits+1-i

            println(ask1)
            query++
            val nextBit = readLine()!!.toInt()
            normal[ask1-1] = nextBit

            println(ask2)
            query++
            val oppositeBit = readLine()!!.toInt()
            normal[ask2-1] = oppositeBit

            if(idxEqual1 == -1 && nextBit == oppositeBit) {
                idxEqual1 = ask1
            }

            if(idxOpposite1 == -1 && nextBit != oppositeBit) {
                idxOpposite1 = ask1
            }

            if(query + 1 % 10 == 1) {

                if(idxEqual1 >= 0 && idxOpposite1 >= 0) {
                    println(idxOpposite1)
                    query++

                    val oppositeBit = readLine()!!.toInt()
                    val previousValue = normal[idxOpposite1 - 1]

                    if (oppositeBit != previousValue) {
                        // aconteceu complemento ou reversal

                        println(idxEqual1)
                        query++

                        val equalBit = readLine()!!.toInt()
                        val previousEqualValue = normal[idxEqual1 - 1]

                        if(equalBit != previousEqualValue) {
                            // aconteceu complemento e reverse
                            normal.reverse()
                            normal.map { v ->
                                if(v > -1) {
                                    if(v == 1) 0 else 1
                                } else {
                                    v
                                }
                            }
                        } else {
                            // aconteceu soh reverse
                            normal.reverse()
                        }
                    } else {
                        println(idxEqual1)
                        query++

                        val equalBit = readLine()!!.toInt()
                        val previousEqualValue = normal[idxEqual1 - 1]

                        if(equalBit != previousEqualValue) {
                            // aconteceu complemento
                            normal.map { v ->
                                if(v > -1) {
                                    if(v == 1) 0 else 1
                                } else {
                                    v
                                }
                            }
                        } // else nada aconteceu
                    }
                } else if (idxEqual1 >= 0) {

                    println(idxEqual1)
                    query++

                    val equalBit = readLine()!!.toInt()
                    val previousEqualValue = normal[idxEqual1 - 1]

                    if(equalBit != previousEqualValue) {
                        // aconteceu complemento
                        normal.map { v ->
                            if(v > -1) {
                                if(v == 1) 0 else 1
                            } else {
                                v
                            }
                        }
                    } // else nada aconteceu

                } else if (idxOpposite1 >= 0) {

                    val oppositeBit = readLine()!!.toInt()
                    val previousValue = normal[idxOpposite1 - 1]

                    if (oppositeBit != previousValue) {
                        normal.reverse()
                    }
                }
            }

            i++
        }

        normal.forEach { print(it) }
        println()

        val response = readLine()!!

        if (response == "N") break
        else {
            normal.map { -1 }
            idxEqual1 = -1
            idxOpposite1 = -1
        }
    }
}