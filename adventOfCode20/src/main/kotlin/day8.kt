import java.io.File

fun day8(): List<Int> {
//    val filename = "src/test/resources/day8.txt"
    val filename = "src/main/resources/day8.txt"
    val instructions = File(filename).readLines().map { it.split(" ") }
    val part1 = part1(instructions)
    val part2 = part2(instructions)
    return listOf(part1[0], part2)
}

fun part1(instructions: List<List<String>>): List<Int> {
    var index = 0
    var acc = 0
    val visited = BooleanArray(instructions.size)
    while (index < instructions.size) {
        visited[index] = true
        when {
            instructions[index][0] == "acc" -> {
                acc += instructions[index][1].toInt()
                index += 1
            }
            instructions[index][0] == "jmp" -> index += instructions[index][1].toInt()
            instructions[index][0] == "nop" -> index += 1
        }
        if (index == instructions.size) return listOf(acc, index)
        if (visited[index]) return listOf(acc, index)
    }
    return listOf(acc, index)
}

fun part2(instructions: List<List<String>>): Int {
    var index = 0
    while (index < instructions.size - 1) {
        val fixedInstructions = instructions.toMutableList()
        if (fixedInstructions[index][0] == "jmp") {
            fixedInstructions[index] = listOf("nop", fixedInstructions[index][1])
            val test = part1(fixedInstructions)
            if (test[1] == instructions.size) {
                return test[0]
            }
        } else if (fixedInstructions[index][0] == "nop") {
            fixedInstructions[index] = listOf("jmp", fixedInstructions[index][1])
            val test = part1(fixedInstructions)
            if (test[1] == instructions.size) {
                return test[0]
            }
        }
            index++
    }
    println("No solution")
    return 0
}

