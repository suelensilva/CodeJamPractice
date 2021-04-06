package challenges2021.qualification

fun main(args: Array<String>) {
    val t = readInt()

    for(i in 1..t) {
        val n = readInt()
        val array = readInts()
        val cost = array.reverseSort()

        println("Case #$i: $cost")
    }
}

private fun Array<Int>.reverseSort(): Int {
    var cost = 0
    for(i in 0 until this.size - 1) {
        val j = this.findMinBetweenIndexAndEnd(i)
        cost += j+1 - i
        this.reverse(i, j+1)
    }

    return cost
}

private fun Array<Int>.findMinBetweenIndexAndEnd(idx: Int): Int {
    var min = idx
    for(i in idx until this.size) {
        if(this[i] < this[min]) {
            min = i
        }
    }
    return min
}

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }.toTypedArray()
