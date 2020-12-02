import java.io.File

fun day1(): MutableList<Int> {
    val day1 = emptyList<Int>().toMutableList()
    val filename = "src/main/resources/day1.txt"
    val myFile = File(filename).readLines()

    day1.add(part1(myFile))
    day1.add(part2(myFile))
    return day1
}

private fun part1(myFile: List<String>): Int {
    for (i in myFile.indices) {
        for (j in i + 1 until myFile.size) {
            if (myFile[i].toInt() + myFile[j].toInt() == 2020) {
                return myFile[i].toInt() * myFile[j].toInt()
            }
        }
    }
    return 0
}

private fun part2(myFile: List<String>): Int {
    for (i in 0..myFile.size - 2) {
        for (j in i + 1 until myFile.size - 1) {
            for (k in j + 1 until myFile.size) {
                if (myFile[i].toInt() + myFile[j].toInt() + myFile[k].toInt() == 2020) {
                    return myFile[i].toInt() * myFile[j].toInt() * myFile[k].toInt()
                }
            }
        }
    }
    return 0
}
