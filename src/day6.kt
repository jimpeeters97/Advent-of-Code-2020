import java.io.File

fun main() {
    val inputList = arrayListOf<String>()

    File("src/files/day6.txt").forEachLine {
        inputList.add(it)
    }

    println("The result of part 1 is: " + countYesAnswers(inputList))
    print("The result of part 2 is:" + countYesEveryoneAnswers(inputList))
}

fun countYesAnswers(inputList: List<String>): Int {
    var result = 0
    val groupAnswers = arrayListOf<Char>()

    for (x in inputList.indices) {
        for (y in inputList[x].indices) {
            if (!groupAnswers.contains(inputList[x][y])) {
                groupAnswers.add(inputList[x][y])
            }
        }

        if (inputList[x].isBlank() || x == (inputList.size - 1)) {
            result += groupAnswers.size
            groupAnswers.clear()
        }
    }
    return result
}

fun countYesEveryoneAnswers(inputList: List<String>): Int {
    val groupList = arrayListOf<String>()
    var result = 0

    for (x in inputList.indices) {

        if (!inputList[x].isBlank()) {
            groupList.add(inputList[x])
        }

        if (inputList[x].isBlank() || x == (inputList.size - 1)) {
            for (z in groupList[0]) {
                var found = true

                for (e in groupList.indices) {
                    if (!groupList[e].contains(z)) {
                        found = false
                        break
                    }
                }

                if (found) {
                    result++
                }
            }

            groupList.clear()
        }
    }
    return result
}