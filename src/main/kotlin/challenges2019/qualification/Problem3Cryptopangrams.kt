package challenges2019.qualification

import java.math.BigInteger

fun main(args: Array<String>) {
    val t = readInt()
    for(i in 1..t) {
        val (n, l) = readBigIntegers()

        val cipher = readBigIntegers()
        val alphabet = mutableSetOf<BigInteger>()
        val pairOfLetters = mutableListOf<Array<BigInteger>>()
        var primeLetter = gcd(cipher[0], cipher[1])

        alphabet.add(cipher[0]/primeLetter)
        alphabet.add(primeLetter)
        pairOfLetters.add(arrayOf(cipher[0]/primeLetter, primeLetter))

        for(j in 1 until cipher.size) {
            val anotherLetter = cipher[j] / primeLetter
            alphabet.add(anotherLetter)
            pairOfLetters.add(arrayOf(primeLetter, anotherLetter))
            primeLetter = anotherLetter
        }

        val sortedAlphabet = alphabet.sorted()
        val alphabetHashMap = hashMapOf<BigInteger, Char>()
        val iterator = ('A'..'Z').iterator()
        for((index, letter) in iterator.withIndex()) {
            alphabetHashMap[sortedAlphabet[index]] = letter
        }

        print("Case #$i: ")
        pairOfLetters.forEachIndexed { index, ints ->
            val (p1, p2) = ints

            if(index < pairOfLetters.size -1) {
                if(pairOfLetters[index+1].contains(p2)) {
                    print(alphabetHashMap[p1])
                } else {
                    print(alphabetHashMap[p2])
                }
            } else {
                if(pairOfLetters[index-1].contains(p2)) {
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

fun gcd(n1: BigInteger, n2: BigInteger): BigInteger {
    var nro1 = n1
    var nro2 = n2
    while (nro1 != nro2) {
        if (nro1 > nro2)
            nro1 -= nro2
        else
            nro2 -= nro1
    }

    return nro1
}

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }
private fun readBigIntegers() = readStrings().map { it.toBigInteger() }