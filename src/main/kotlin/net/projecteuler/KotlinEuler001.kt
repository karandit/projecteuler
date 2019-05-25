package net.projecteuler

fun euler001(): String=
        (1..999)
                .filter { it % 3 == 0 || it % 5 == 0}
                .sum()
                .toString()

