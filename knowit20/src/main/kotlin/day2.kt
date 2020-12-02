fun day2(): Int {
    val population = 5433000
    var i = 0
    val packages = emptyList<Int>().toMutableList()

    while (i <= population) {
        if (i.toString().contains('7')) {
            val prime = getPrime(i)
            i += prime
        } else {
            packages.add(i)
        }
        i++
    }
    return packages.size
}

fun getPrime(number: Int): Int {
    for (i in number downTo 7) {
        var flag = true
        for (j in 2..i / 2) {
            if (i % j == 0) {
                flag = false
                break
            }
        }
        if (flag) {
            return i
        }
    }
    return 0
}
