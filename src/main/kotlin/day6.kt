val inputLines6 = object {}.javaClass.getResourceAsStream("day6input.txt")?.bufferedReader()?.readLines()!!

fun String.findMarkers(n: Int): Int {
    for (i in n-1 until this.length) {
        var distinct = "${this[i]}"
        for (j in i-1 downTo 0) {
            if (!distinct.contains(this[j])) {
                distinct += this[j]
            } else {
                break
            }
        }
        if (distinct.length == n) {
            return i + 1
        } else {
            distinct = ""
        }
    }
    return -1
}

fun main() {
    /* ***** PART 1 ***** */
    println(inputLines6[0].findMarkers(4))

    /* ***** PART 2 ***** */
    println(inputLines6[0].findMarkers(14))
}