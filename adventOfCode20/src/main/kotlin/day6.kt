import java.io.File

fun day6(): List<Int> {
    val filename = "src/main/resources/day6.txt"
    val groupAnswers = File(filename).readText().trim().split("\n\n")
    val part1 = groupAnswers.map { it.replace("\n", "") }.map { it.toCharArray().toSet().count() }.sum()
    val part2 = groupAnswers.map { it.split("\n").map(String::toSet).reduce(Set<Char>::intersect).size }.sum()

    return listOf(part1, part2)
}