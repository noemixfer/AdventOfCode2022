var inputLines1 = object {}.javaClass.getResourceAsStream("input.txt")?.bufferedReader()?.readLines()!!

// Part 1
fun List<String>.elfSplitted(): List<List<String>> {
    var idx = emptyList<Int>()
    for (i in this.indices) {
        if (this[i].isEmpty())
            idx += i
    }
    idx += this.size
    val outcome = mutableListOf(this.subList(0, idx[0]))
    for (i in 1 until idx.size) {
        outcome += this.subList(idx[i-1], idx[i])
    }
    for (i in 1 until outcome.size) {
        outcome[i] = outcome[i].drop(1)
    }
    return outcome
}

fun List<List<String>>.convertCalories(): List<List<Int>> {
    return this.map { list ->
        list.map { it.toInt() }
    }
}

fun List<List<Int>>.findGreatest(): Int {
    val sum = this.map { list ->
        list.sumOf { it }
    }
    return sum.maxOf { it }
}

// Part 2
fun List<List<Int>>.findGreatestThree(): Int {
    val sum = this.map { list ->
        list.sumOf { it }
    }.sortedDescending()
    return sum.filter { it > sum[3] }.sumOf { it }
}

fun main() {
    /* ***** PART ONE ***** */
    println("The Elf carrying the most Calories is carrying a total of ${inputLines1.elfSplitted().convertCalories().findGreatest()} Calories!")

    /* ***** PART TWO ***** */
    println("The 3 Elves carrying the most Calories are carrying a total of ${inputLines1.elfSplitted().convertCalories().findGreatestThree()} Calories!")
}