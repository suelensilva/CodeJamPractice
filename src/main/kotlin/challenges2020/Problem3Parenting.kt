package challenges2020

const val START = 0
const val END = 1

fun main(args: Array<String>) {

    val nTests = readLine()!!.toInt()

    for(i in 1..nTests) {
        val n = readLine()!!.toInt()

        val intervals = Array(n) {
            readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
        }
        val schedule = calculateSchedules(intervals)

        println("Case #$i: $schedule")
    }
}

fun calculateSchedules(times: Array<Array<Int>>): String {

    val c = mutableListOf<Array<Int>>()
    val j = mutableListOf<Array<Int>>()

    val intervals = times.copyOf()
    intervals.sortBy { it[0] }
    intervals.forEach { curr ->
        when {
            canBeAssigned(curr, c) -> c.add(curr)
            canBeAssigned(curr, j) -> j.add(curr)
            else -> return "IMPOSSIBLE"
        }
    }

    var schedule = ""
    times.forEach {
        schedule += if(c.contains(it)) "C" else "J"
    }
    return schedule
}

fun canBeAssigned(activity: Array<Int>, previousAssignedList: List<Array<Int>>): Boolean {
    previousAssignedList.forEach { prev ->
        if( (activity[START] >= prev[START] && activity[START] < prev[END]) ||
            (activity[END] > prev[START] && activity[END] <= prev[END]) ) {
            return false
        }
    }
    return true
}