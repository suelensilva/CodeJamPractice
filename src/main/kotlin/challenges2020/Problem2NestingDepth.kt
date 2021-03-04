package challenges2020

fun main(args: Array<String>) {

    val nTests = readLine()!!.toInt()

    for(i in 1..nTests) {
        val digits = readLine()!!
        val nestedDigits = nestDepth(digits)
        println("Case #$i: $nestedDigits")
    }
}

fun nestDepth(input: String): String {
    val inputBuffer = StringBuilder()
    var open = 0
    input.forEach { c ->
        val d = Character.getNumericValue(c)
        when {
            d < open -> {
                val numberOfClose = open - d
                for (i in 1..numberOfClose) inputBuffer.append(')')
                inputBuffer.append(c)
                open = d
            }
            d > open -> {
                val numberOfOpen = d - open
                for(i in 1..numberOfOpen) inputBuffer.append('(')
                inputBuffer.append(c)
                open = d
            }
            d == open -> {
                inputBuffer.append(c)
            }
        }
    }
    for(i in 1..open) inputBuffer.append(')')
    return inputBuffer.toString()
}