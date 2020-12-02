import java.io.BufferedReader
import java.io.File

fun day1(): Int {
    val filename = "src/main/resources/day1.txt"
    val bufferedReader: BufferedReader = File(filename).bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    val numbers = inputString.split(",").map { it.toInt() }.sorted()
    for (i in 1 until 100000) {
        if (numbers[i-1] != i) {
            return i
        }
    }
    return 0
}