package challenges2019.qualification

fun main(args: Array<String>) {
    val nTests = readLine()!!.toInt()
    for(i in 1..nTests) {
        val n = readLine()!!.toInt()
        val lidiaPath = readLine()!!
        val myPath = lidiaPath.map {
            if(it == 'E') 'S' else 'E'
        }
        print("Case #$i: ")
        myPath.forEach { print(it) }
        println()
    }
}