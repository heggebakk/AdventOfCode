import java.io.File

fun day5(): List<Int> {
    val filename = "src/main/resources/day5.txt"
    val boardingPasses = File(filename).readLines()
    var highestSeatID = 0
    val seatIDs = emptyList<Int>().toMutableList()

    for (boardingPass in boardingPasses) {
        val letters = boardingPass.toCharArray()
        var row = (0..127).toList()
        var column = (0..7).toList()
        for (letter in letters) {
            val middleRow = row.size / 2
            val middleColumn = column.size / 2
            when (letter) {
                'F' -> {
                    row = row.subList(0,middleRow)
                }
                'B' -> {
                    row = row.subList(middleRow, row.size)
                }
                'R' -> {
                    column = column.subList(middleColumn, column.size)
                }
                'L' -> {
                    column = column.subList(0, middleColumn)
                }
            }
        }
        val seatID = row[0] * 8 + column[0]
        seatIDs.add(seatID)
        if (seatID > highestSeatID) {
            highestSeatID = seatID
        }
    }

    seatIDs.sort()
    var mySeat = 0
    for (i in 1..seatIDs.size-2) {
        if (seatIDs[i] + 1 != seatIDs[i + 1]) {
            mySeat = seatIDs[i] + 1
        }
    }

    return listOf(highestSeatID, mySeat)
}
