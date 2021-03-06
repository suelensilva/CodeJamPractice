package challenges2020

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

fun calculateSchedules(intervals: Array<Array<Int>>): String {
    var schedule = ""
    val c = mutableListOf<Array<Int>>()
    val j = mutableListOf<Array<Int>>()
    intervals.forEach { curr ->
        var addedC = false
        if(c.isEmpty()) {
            c.add(curr)
            schedule += "C"
            addedC = true
        } else {
            var hasConflict = false
            c.forEach {
                if((curr[0] > it[0] && curr[0] < it[1]) ||
                    (curr[1] > it[0] && curr[1] < it[1]) ) {
                    hasConflict = true
                }
            }
            if(!hasConflict) {
                c.add(curr)
                schedule += "C"
                addedC = true
            }
        }

        if(!addedC) {
            if(j.isEmpty()) {
                j.add(curr)
                schedule += "J"
            } else {
                var hasConflict = false
                j.forEach {
                    if((curr[0] > it[0] && curr[0] < it[1]) ||
                        (curr[1] > it[0] && curr[1] < it[1]) ) {
                        hasConflict = true
                    }
                }
                if(!hasConflict) {
                    j.add(curr)
                    schedule += "J"
                } else {
                    return "IMPOSSIBLE"
                }
            }
        }
    }
    return schedule
}