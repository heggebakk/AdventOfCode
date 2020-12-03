import java.io.File

fun day3(): MutableList<Long> {
    val filename = "src/main/resources/day3.txt"
    val myFile = File(filename).readLines()
    val results = emptyList<Long>().toMutableList()

    results.add(part1(myFile))
    results.add(part2(myFile))
    return results
}

private fun part1(myFile: List<String>, x: Int=3, y: Int=1): Long {
    var encounters = 0
    var tempX = 0
    var tempY = 0

    while (tempY < myFile.size) {
        val line = myFile[tempY]
        val position = line[tempX]
        if (position == '#') {
            encounters++
        }
        tempX = (tempX + x) % line.length
        tempY += y
    }

    return encounters.toLong()
}

private fun part2(myFile: List<String>): Long {
    val one = part1(myFile, 1, 1)
    val two = part1(myFile)
    val tree = part1(myFile, 5, 1)
    val four = part1(myFile, 7, 1)
    val five = part1(myFile, 1, 2)
    println(one)
    println(two)
    println(tree)
    println(four)
    println(five)
    return (one * two * tree * four * five)
}
