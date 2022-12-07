import java.io.File

val inputLines3 = File("C:\\ISEL\\AdventOfCode2022\\AdventOfCode2022\\src\\main\\resources\\day3input.txt").readLines()

// Part 1
fun List<String>.firstHalf(): List<String> =
    this.map { it.dropLast(it.length/2) }

fun List<String>.secondHalf(): List<String> =
    this.map { it.drop(it.length/2) }

fun findEquals(a: List<String>, b: List<String>): List<Char> {
    var equals = emptyList<Char>()
    for (i in a.indices) {
        for (j in a[i].indices) {
            if (b[i].contains(a[i][j])) {
                equals += a[i][j]
                break
            }
        }
    }
    return equals
}

fun List<Char>.priority() =
    this.map { if (it.code in 97..122) it.code - 96 else it.code - 38 }

fun List<Int>.prioritySum() =
    this.sumOf { it }

// Part 2

val splitted = inputLines3.chunked(3)

fun List<List<String>>.findEqualsInGroups(): List<Char> {
    var equals = emptyList<Char>()
    for (i in this.indices) {
        for (j in this[i].indices) {
            for(l in this[i][j].indices) {
                if (this[i][j + 1].contains(this[i][j][l]) && this[i][j + 2].contains(this[i][j][l])) {
                    equals += this[i][j][l]
                    break
                }
            }
            break
        }
    }
    return equals
}

fun main() {
    /* ***** PART ONE ***** */
    val equals = findEquals(inputLines3.firstHalf(), inputLines3.secondHalf())
    println(equals.priority().prioritySum())

    /* ***** PART TWO ***** */
    println(splitted.findEqualsInGroups().priority().prioritySum())
}