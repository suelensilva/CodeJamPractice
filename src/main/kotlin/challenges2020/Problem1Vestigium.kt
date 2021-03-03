package challenges2020

fun main(args: Array<String>) {

    val nTests = readLine()!!.toInt()

    for(i in 1..nTests) {
        val n = readLine()!!.toInt()

        val matrix = Array(n) {
            readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
        }

        val trace = getTrace(n, matrix)
        val rowsRepetitions = getRepetitionsInRows(n, matrix)
        val columnsRepetitions = getRepetitionsInColumns(n, matrix)

        println("Case #$i: $trace $rowsRepetitions $columnsRepetitions")
    }
}

fun getTrace(n: Int, matrix: Array<Array<Int>>): Int {
    var trace = 0
    for(i in 0 until n) {
        trace += matrix[i][i]
    }
    return trace
}

fun getRepetitionsInRows(n: Int, matrix: Array<Array<Int>>): Int {
    var repetitions = 0
    matrix.forEach {
        if(it.distinct().size < n) {
            repetitions++
        }
    }
    return repetitions
}

fun getRepetitionsInColumns(n: Int, matrix: Array<Array<Int>>): Int {
    val columns = (matrix.indices)
        .map { columnIndex -> matrix.map { it[columnIndex] }.toTypedArray() }
        .toTypedArray()
    return getRepetitionsInRows(n, columns)
}

