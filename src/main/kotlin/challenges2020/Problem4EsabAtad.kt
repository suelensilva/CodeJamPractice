package challenges2020

fun main(args: Array<String>) {

    val firstInput = readLine()!!.split(" ").map{ it.toInt() }

    val nTests = firstInput[0]
    val nBits = firstInput[1]

    val normal = IntArray(nBits)
    val complement = IntArray(nBits)
    val reverse = IntArray(nBits)
    val complementReversed = IntArray(nBits)

    for(t in 1 .. nTests) {
        for (i in 1..nBits) {
            println(i)
            val nextBit = readLine()!!.toInt()

            normal[i - 1] = nextBit
//        complement[i-1] = if(nextBit == 1) 0 else 1
//        reverse[nBits - 1 - i] = nextBit
//        complementReversed[nBits - 1 - i] = if(nextBit == 1) 0 else 1
        }
        normal.forEach { print(it) }
        println()

        val response = readLine()!!

        if (response == "N") break
    }
}