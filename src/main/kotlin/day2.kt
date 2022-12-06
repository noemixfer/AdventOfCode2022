import java.io.File

val inputLines = File("C:\\ISEL\\AdventOfCode2022\\AdventOfCode2022\\src\\main\\resources\\day2input.txt").readLines()

// Part 1
fun List<String>.myPoints(): Int {
    var points = 0
    this.forEach {
        if ((it[0] == 'A' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 3 // Draw
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'C' && it[2] == 'Y')) points += 0 // Lose
        else if ((it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')) points += 6 // Win
    }
    this.forEach {
        if (it[2] == 'X') points += 1 // Rock
        else if (it[2] == 'Y') points += 2 // Paper
        else if (it[2] == 'Z') points += 3 // Scissors
    }
    return points
}

fun List<String>.elfPoints(): Int {
    var points = 0
    this.forEach {
        if ((it[0] == 'A' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 3 // Draw
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'C' && it[2] == 'Y')) points += 6 // Win
        else if ((it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')) points += 0 // Lose
    }
    this.forEach {
        if (it[0] == 'X') points += 1 // Rock
        else if (it[0] == 'Y') points += 2 // Paper
        else if (it[0] == 'Z') points += 3 // Scissors
    }
    return points
}

// Part 2

fun List<String>.updatedMyPoints(): Int {
    var points = 0
    this.forEach {
        if (it[2] == 'X') points += 0 // Lose
        else if (it[2] == 'Y') points += 3 // Draw
        else if (it[2] == 'Z') points += 6 // Win
    }
    this.forEach {
        if ((it[0] == 'B' && it[2] == 'X')
            || (it[0] == 'A' && it[2] == 'Y')
            || (it[0] == 'C' && it[2] == 'Z')) points += 1 // Rock
        else if ((it[0] == 'A' && it[2] == 'Z')
            || (it[0] == 'C' && it[2] == 'X')
            || (it[0] == 'B' && it[2] == 'Y')) points += 2 // Paper
        else if ((it[0] == 'C' && it[2] == 'Y')
            || (it[0] == 'B' && it[2] == 'Z')
            || (it[0] == 'A' && it[2] == 'X')) points += 3 // Scissors
    }
    return points
}


fun main() {
    println("***** PART ONE *****")
    println("My score is ${inputLines.myPoints()}")
    println("The elf's score is ${inputLines.elfPoints()}")
    println(if (inputLines.myPoints() > inputLines.elfPoints()) "I win!"
            else if (inputLines.elfPoints() > inputLines.myPoints()) "The elf wins..."
            else "It's a draw!")

    println()

    println("***** PART TWO *****")
    println("My updated score is ${inputLines.updatedMyPoints()}")
    println("The elf's score is ${inputLines.elfPoints()}")
    println(if (inputLines.updatedMyPoints() > inputLines.elfPoints()) "I win!"
    else if (inputLines.elfPoints() > inputLines.updatedMyPoints()) "The elf wins..."
    else "It's a draw!")
}