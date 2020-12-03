import java.io.File

fun main() {
    val lines = arrayListOf<String>()

    File("src/files/day2.txt").forEachLine {
        lines.add(it)
    }

    println("The result for part 1 is: ${validPasswordsPart1(lines)}")
    println("The result for part 2 is: ${validPasswordsPart2(lines)}")
}

fun validPasswordsPart1(lines: List<String>): Int {
    var result = 0
    lines.forEach { it ->
        run {
            val min = it.substring(0, (it.indexOf("-"))).toInt()
            val max = it.substring(it.indexOf("-") + 1, it.indexOf(":") - 2).toInt()
            val char = it.substring(it.indexOf(":") - 1, it.indexOf(":"))

            val password = it.substring(it.indexOf(": ") + 2)

            if (password.toCharArray().filter { ch -> ch == char[0]; }.size in min..max) {
                result++
            }
        }
    }
    return result
}

fun validPasswordsPart2(lines: List<String>): Int {
    var result = 0
    lines.forEach { it ->
        run {
            val min = it.substring(0, (it.indexOf("-"))).toInt()
            val max = it.substring(it.indexOf("-") + 1, it.indexOf(":") - 2).toInt()
            val char = it.substring(it.indexOf(":") - 1, it.indexOf(":"))

            val password = it.substring(it.indexOf(": ") + 2)

            val minMatched = password[min - 1] == char[0]
            val maxMatched = password[max - 1] == char[0]

            if((minMatched || maxMatched) && !(minMatched && maxMatched)) {
                result++
            }
        }
    }
    return result
}