package net.projecteuler

import java.math.BigInteger

fun euler013(): String {
    return KotlinEuler::class.java
            .getResourceAsStream("ProjectEuler_013.txt")
            .bufferedReader()
            .readLines()
            .fold(BigInteger.ZERO, {acc, line -> acc.add(BigInteger(line))})
            .toString()
            .substring(0..9)
}