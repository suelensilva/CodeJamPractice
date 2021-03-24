package challenges2019

fun main(args: Array<String>) {
    val t = readInt()
    for(i in 1..t) {
        val (n, l) = readInts()

        val primes = primes(n)

        val cipher = readInts()

        val alphabet = mutableSetOf<Int>()
        val pairOfIntLetters = mutableListOf<Array<Int>>()
        cipher.forEach { c ->
            val (f1, f2) = findFactors(c, primes)
            alphabet.add(f1)
            alphabet.add(f2)
            pairOfIntLetters.add(arrayOf(f1, f2))
        }

        val sortedAlphabet = alphabet.sorted()
        val alphabetHashMap = hashMapOf<Int, Char>()
        val iterator = ('A'..'Z').iterator()
        for((index, letter) in iterator.withIndex()) {
            alphabetHashMap[sortedAlphabet[index]] = letter
        }

        print("Case #$i: ")
        pairOfIntLetters.forEachIndexed { index, ints ->
            val (p1, p2) = ints

            if(index < pairOfIntLetters.size -1) {
                if(pairOfIntLetters[index+1].contains(p2)) {
                    print(alphabetHashMap[p1])
                } else {
                    print(alphabetHashMap[p2])
                }
            } else {
                if(pairOfIntLetters[index-1].contains(p2)) {
                    print(alphabetHashMap[p2])
                    print(alphabetHashMap[p1])
                } else {
                    print(alphabetHashMap[p1])
                    print(alphabetHashMap[p2])
                }
            }
        }

        println()
    }
}

fun primes(n: Int) = (2..n).filter { num -> (2 until num).none { num % it == 0 } }

fun findFactors(f: Int, primes: List<Int>) = primes.filter { n -> primes.any { it * n == f } }

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }