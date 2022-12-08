data class Instruct (val box: Int, val from: Int, val to: Int)

// PART 1
val inputLines5 = object {}.javaClass.getResourceAsStream("day5input.txt")?.bufferedReader()?.readLines()!!
val stacks = inputLines5.dropLast(inputLines5.size - 9).toMutableList()
val instructions = inputLines5.drop(10)
val instructList = populate(instructions.getBoxNumbers(), instructions.getOrigin(), instructions.getDestination())
val stackBoxes = stacks.map { it.chunked(4) }
val stackedUp = listOf(
    stackBoxes.stackup(1),
    stackBoxes.stackup(2),
    stackBoxes.stackup(3),
    stackBoxes.stackup(4),
    stackBoxes.stackup(5),
    stackBoxes.stackup(6),
    stackBoxes.stackup(7),
    stackBoxes.stackup(8),
    stackBoxes.stackup(9)
)

fun List<String>.getBoxNumbers(): List<Int> {
    var box = emptyList<Int>()
    for (i in this.indices) {
        val parts = this[i].split(" ")
        box += parts[1].toInt()
    }
    return box
}
fun List<String>.getOrigin(): List<Int> {
    var moveFrom = emptyList<Int>()
    for (i in this.indices) {
        val parts = this[i].split(" ")
        moveFrom += parts[3].toInt()
    }
    return moveFrom
}

fun List<String>.getDestination(): List<Int> {
    var moveTo = emptyList<Int>()
    for (i in this.indices) {
        val parts = this[i].split(" ")
        moveTo += parts[5].toInt()
    }
    return moveTo
}

fun populate (a: List<Int>, b: List<Int>, c: List<Int>): List<Instruct> {
    var list = emptyList<Instruct>()
    for (i in a.indices) {
        list += Instruct(a[i], b[i], c[i])
    }
    return list
}

fun List<List<String>>.stackup (stackNum: Int): MutableList<String> {
    val stackedUp = emptyList<String>().toMutableList()
    this.forEach { it.forEachIndexed { idx, s ->
        if ((idx == stackNum - 1)
            && (s.contains("[") || s.contains("$stackNum")))
            stackedUp += s } }
    return stackedUp.asReversed()
}

fun List<Instruct>.moveAll (stacks: List<MutableList<String>>): List<MutableList<String>> {
    val list = stacks
    for (i in this.indices) {
        for (j in list.indices) {
            if (list[j][0].contains("${this[i].from}")) {
                val boxToMove = list[j].takeLast(this[i].box).asReversed()
                list[this[i].to - 1] += boxToMove
                for (l in list[j].size - 1 downTo list[j].size - this[i].box) {
                    list[j].removeAt(l)
                }
            }
        }
    }
    return list
}

// PART 2
fun List<Instruct>.moveAllAtOnce (stacks: List<MutableList<String>>): List<MutableList<String>> {
    val list = stacks
    for (i in this.indices) {
        for (j in list.indices) {
            if (list[j][0].contains("${this[i].from}")) {
                val boxToMove = list[j].takeLast(this[i].box)
                list[this[i].to - 1] += boxToMove
                for (l in list[j].size - 1 downTo list[j].size - this[i].box) {
                    list[j].removeAt(l)
                }
            }
        }
    }
    return list
}

fun main() {
    /* ***** PART ONE ***** */
    println(stackedUp)
    println(instructList.moveAll(stackedUp))
//    for (i in instructList.moveAll(stackedUp).indices) {
//        print(instructList.moveAll(stackedUp)[i][instructList.moveAll(stackedUp).size - 1])
//    }
    /* I was able to move the boxes correctly from one stack to another
     * However, I couldn't take the last item from each stack and form a string
     * (I tried in so many different ways and nothing worked!!)
     * So I just printed the stacks in the final form and took note of each stack's last item
     * The output was supposed to be RLFNRTNFB
     */

    /* ***** PART TWO ***** */
    /* Just as in Part 1, I wasn't able to form a string,
     * So I just printed the final stack form and took note of every stack's last item
     * The output was supposed to be MHQTLJRLB
     */
    println(instructList.moveAllAtOnce(stackedUp))
}