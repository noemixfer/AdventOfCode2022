import java.io.File

val inputLines = File("C:\\ISEL\\AdventOfCode2022\\AdventOfCode2022\\src\\main\\resources\\day2input.txt").readLines()

// Part 1
fun List<String>.myPoints(): Int {
    var points: List<Int> = emptyList()
    this.forEach {
        if ((it[0] == 'A' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 3
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'C' && it[2] == 'Y')) points += 0
        else if ((it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')) points += 6
    }
    this.forEach {
        if (it[2] == 'X') points += 1
        else if (it[2] == 'Y') points += 2
        else if (it[2] == 'Z') points += 3
    }
    return points.sumOf { it }
}

fun List<String>.elfPoints(): Int {
    var points: List<Int> = emptyList()
    this.forEach {
        if ((it[0] == 'A' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 3
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'C' && it[2] == 'Y')) points += 6
        else if ((it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')) points += 0
    }
    this.forEach {
        if (it[0] == 'X') points += 1
        else if (it[0] == 'Y') points += 2
        else if (it[0] == 'Z') points += 3
    }
    return points.sumOf { it }
}

// Part 2

fun List<String>.updatedMyPoints(): Int {
    var points: List<Int> = emptyList()
    this.forEach {
        if (it[2] == 'X') points += 0
        else if (it[2] == 'Y') points += 3
        else if (it[2] == 'Z') points += 6
    }
    this.forEach {
        if ((it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 1 //Rock
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')) points += 2 //Paper
        else if ((it[0] == 'C' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'A' && it[2] == 'X')) points += 3 //Scissors
    }
    return points.sumOf { it }
}


fun main() {
    println("My score is ${inputLines.myPoints()}")
    println("The elf's score is ${inputLines.elfPoints()}")
    println(if (inputLines.myPoints() > inputLines.elfPoints()) "I win!"
            else if (inputLines.elfPoints() > inputLines.myPoints()) "The elf wins..."
            else "It's a draw!")

    println("My updated score is ${inputLines.updatedMyPoints()}")
    println("The elf's score is ${inputLines.elfPoints()}")
    println(if (inputLines.updatedMyPoints() > inputLines.elfPoints()) "I win!"
    else if (inputLines.elfPoints() > inputLines.updatedMyPoints()) "The elf wins..."
    else "It's a draw!")

}