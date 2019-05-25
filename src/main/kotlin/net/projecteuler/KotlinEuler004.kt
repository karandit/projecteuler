package net.projecteuler

fun euler004(): String =
        (100..999)
                .flatMap {n1 -> (100..999).map {n2 -> n1 * n2}   }
                .filter { n -> val s = n.toString(); s.reversed().equals(s) }
                .max()
                ?.toString() ?: "no solution"


