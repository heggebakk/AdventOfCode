import java.io.File

fun day2(): MutableList<Int> {
    val filename = "src/main/resources/day2.txt"
    val myFile = File(filename).readLines()
    val result = emptyList<Int>().toMutableList()

    result.add(part1(myFile))
    result.add(part2(myFile))

    return result
}

private fun part1(myFile: List<String>): Int {
    var validPasswords = 0

    for (line in myFile) {
        val parts = line.split(' ')
        val low = parts[0].split("-")[0].toInt()
        val high = parts[0].split("-")[1].toInt()
        val char = parts[1].first()
        val password = parts[2]
        var isValid = true

        if (password.filter { it == char }.count() < low || password.filter { it == char }.count() > high) {
            isValid = false
        }
        if (isValid) {
            validPasswords++
        }
    }
    return validPasswords
}

private fun part2(myFile: List<String>): Int {
    var validPasswords = 0

    for (line in myFile) {
        val parts = line.split(' ')
        val low = parts[0].split("-")[0].toInt() - 1
        val high = parts[0].split("-")[1].toInt() - 1
        val char = parts[1].first()
        val password = parts[2]

        if (password[low] == char && password[high] == char) {
            continue
        }
        if (password[low] != char && password[high] != char) {
            continue
        }
        validPasswords++

    }
    return validPasswords
}