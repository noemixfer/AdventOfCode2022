val inputLines4 = object {}.javaClass.getResourceAsStream("day4input.txt")?.bufferedReader()?.readLines()!!

// Part 1
fun List<String>.countRangesFullyContained(): Int {
    var count = 0
    for (i in this.indices) {
        val ranges = this[i].split(",")
        val a = ranges[0].split("-")[0].toInt()
        val b = ranges[0].split("-")[1].toInt()
        val c = ranges[1].split("-")[0].toInt()
        val d = ranges[1].split("-")[1]. toInt()
        if ((a >= c && b <= d) || (c >= a && d <= b))
            count++
    }
    return count
}

// Part 2
fun List<String>.countRangesOverlaps(): Int {
    var count = 0
    for (i in this.indices) {
        val ranges = this[i].split(",")
        val a = ranges[0].split("-")[0].toInt()
        val b = ranges[0].split("-")[1].toInt()
        val c = ranges[1].split("-")[0].toInt()
        val d = ranges[1].split("-")[1]. toInt()
        if (a in c..d
            || b in c..d
            || c in a..b
            || d in a..b)
            count++
    }
    return count
}

fun main() {
    /* ***** PART ONE ***** */
    println("In how many assignment pairs does one range fully contain the other? ${inputLines4.countRangesFullyContained()}")

    /* ***** PART TWO ***** */
    println("In how many assignment pairs do the ranges overlap? ${inputLines4.countRangesOverlaps()}")
}