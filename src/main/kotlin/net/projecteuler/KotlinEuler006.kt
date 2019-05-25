package net.projecteuler

fun euler006(): String = diffSummOfSquare(100).toString()


private  fun diffSummOfSquare(n: Int) : Int {
    val sumOfSquares = IntRange(1,  n).map { it * it }.sum()
    val sum = IntRange(1,  n).sum()
    return sum * sum - sumOfSquares

}
