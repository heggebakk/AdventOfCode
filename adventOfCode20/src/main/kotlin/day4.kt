import java.io.File

fun day4(): List<Int> {
    val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    val filename = "src/main/resources/day4.txt"
    val myFile = File(filename).readText()
    val passports = myFile.split("\n\n").map { it.replace("\n", " ") }

    var part1Result = 0
    var part2Result = 0

    for (passport in passports) {
        val fields = emptyMap<String, String>().toMutableMap()
        for (field in passport.split(" ")) {
            fields[field.split(":")[0]] = field.split(":")[1]
        }
        if (part1(requiredFields, fields)) {
            part1Result ++
        }
        if (part2(requiredFields, fields)) {
            part2Result++
        }
    }

    return listOf(part1Result, part2Result)
}

private fun part1(requiredFields: List<String>, fields: Map<String, String>): Boolean {
    for (requiredField in requiredFields) {
        if (requiredField !in fields.keys) {
            return false
        }
    }
    return true
}

private fun part2(requiredFields: List<String>, fields: Map<String, String>): Boolean {
    if (!part1(requiredFields, fields)) {
        return false
    }

    for (field in fields) {
        if (field.key == "byr") {
            if (field.value.length != 4 || field.value.toInt() !in 1920..2002) {
                return false
            }
        }
        else if (field.key == "iyr") {
            if (field.value.length != 4 || field.value.toInt() !in 2010..2020) {
                return false
            }
        }
        else if (field.key == "eyr") {
            if (field.value.length != 4 || field.value.toInt() !in 2020..2030) {
                return false
            }
        }
        else if (field.key == "hgt") {
            if (field.value.endsWith("cm")) {
                if (field.value.replace("cm", "").toInt() !in 150..193) {
                    return false
                }
            }
            else if (field.value.endsWith("in")) {
                if (field.value.replace("in", "").toInt() !in 59..76) {
                    return false
                }
            } else return false
        }
        else if (field.key == "hcl") {
            if (!field.value.startsWith("#") || field.value.length != 7) {
                return false
            }
        }
        else if (field.key == "ecl") {
            val eyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
            if (!eyeColors.contains(field.value)) {
                return false
            }
        }
        else if (field.key == "pid") {
            if (field.value.length != 9) {
                return false
            }
        }
    }
    return true
}