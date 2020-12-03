import java.io.File

fun main() {
    val treeList = arrayListOf<String>()

    File("src/files/day3.txt").forEachLine {
        treeList.add(it)
    }

    println("The result of part 1 is: " + countTrees(treeList, 3, 1))

    val result = countTrees(treeList, 1, 1).toBigDecimal() *
            countTrees(treeList, 3, 1).toBigDecimal() *
            countTrees(treeList, 5, 1).toBigDecimal() *
            countTrees(treeList, 7, 1).toBigDecimal() *
            countTrees(treeList, 1, 2).toBigDecimal()


    println("The result of part 2 is: $result")
}


fun countTrees(treeList: List<String>, right: Int, down: Int): Int {
    var idx = 0
    var result = 0

    for (x in down until treeList.size step down) {
        idx = (idx + right) % treeList[x].length
        val char = treeList[x][(idx % treeList[x].length)]

        if (char == '#') {
            result++
        }

    }

    return result
}