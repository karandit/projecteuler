package net.projecteuler

fun euler009(): String {
    var a = 1
    while (a <= 1000) {

        var b = a + 1
        while (a + b <= 1000) {
            val c = 1000 - a - b
            if (a * a + b * b == c * c) {
                return (a * b * c).toString()
            }
            b += 1
        }
        a += 1
    }
    return "no solution"
}