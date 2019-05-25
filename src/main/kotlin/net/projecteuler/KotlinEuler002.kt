package net.projecteuler

fun euler002(): String =
        generateSequence(Pair(1, 2),
           { if (it.first > 4_000_000) null else Pair( it.second, it.first + it.second)} )
        .map { it.first }
        .filter {  it % 2 ==0 }
        .sum()
        .toString()

