import java.io.File

fun day9(): List<Long> {
    val filename = "src/main/resources/day9.txt"
//    val filename = "src/test/resources/day9.txt"
    val numberSeries = File(filename).readLines().map { it.toLong() }
    val part1 = xmas(numberSeries)
    val part2 = encryptionWeakness(numberSeries, part1)
    return listOf(part1, part2)
}

fun xmas(numberSeries: List<Long>, preamble: Int = 25): Long {
    if (numberSeries.size < preamble) {
        return 0
    }
    var index = preamble
    while (index < numberSeries.size) {
        var isValid = false
        for (i in (index - preamble)..index) {
            for (j in (i + 1)..index) {
                if (numberSeries[i] + numberSeries[j] == numberSeries[index]) {
                    isValid = true
                    break
                }
            }
            if (isValid) break
        }
        if (!isValid) return numberSeries[index]
        index++
    }
    return 0
}

fun encryptionWeakness(numberSeries: List<Long>, target: Long): Long {
    return 0
}