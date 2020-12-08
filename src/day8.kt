import java.io.File

fun main() {
    val instructions = arrayListOf<Pair<String, Int>>()

    File("src/files/day8.txt").forEachLine {
        val operation = it.substringBefore(" ").replace(" ", "")
        val argument = it.substringAfter(" ").replace(" ", "").toInt()

        instructions.add(Pair(operation, argument))
    }

    println("The result of part 1 is: " + boot(instructions))
}

fun boot(instructions: List<Pair<String, Int>>): Int {
    var acc = 0
    var x = 0
    val visited = arrayListOf<Int>()

    while (x < instructions.size) {
        when (instructions[x].first) {
            "acc" -> {
                acc += instructions[x].second
                x++
            }
            "jmp" -> {
                x += instructions[x].second
            }
            else -> {
                x++
            }
        }

        if (visited.contains(x)) {
            break
        }

        visited.add(x)
    }
    return acc
}