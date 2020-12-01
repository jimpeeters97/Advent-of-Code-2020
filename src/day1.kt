import java.io.File

fun main() {
    val entryList = arrayListOf<Int>()

    File("src/files/day1.txt").forEachLine {
        entryList.add(it.toInt())
    }

    println("The result for part 1 is: " + findEntriesSum2020(entryList))
    println("The result for part 2 is: " + findEntriesProduct2020(entryList))
}

fun findEntriesSum2020(entryList: List<Int>): Int {
    for (x in 0 until entryList.size) {
        for (y in 0 until entryList.size) {
            if (entryList[x] + entryList[y] == 2020) {
                return entryList[x] * entryList[y];
            }
        }
    }
    return 0;
}

fun findEntriesProduct2020(entryList: List<Int>) : Int {
    for (x in 0 until entryList.size) {
        for (y in 0 until entryList.size) {
            for(z in 0 until entryList.size) {
                if (entryList[x] + entryList[y] + entryList[z] == 2020) {
                    return entryList[x] * entryList[y] * entryList[z];
                }
            }
        }
    }
    return 0;
}