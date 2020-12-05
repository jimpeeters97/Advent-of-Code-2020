import java.io.File
import kotlin.math.ceil

fun main() {
    var highestSeat = 0
    val seatList = arrayListOf<Int>()

    File("src/files/day5.txt").forEachLine {
        val seat = getSeat(it)
        if(seat > highestSeat) {
            highestSeat = seat
        }
        seatList.add(seat)
    }

    println("The result of part 1 is: $highestSeat")
    println("The result of part 2 is: " + getOwnSeat(seatList))
}

fun getSeat(bin: String) : Int {
    var stIdx = 0.0
    var endIdx = 127.0

    for(i in 0..6) {
        if(bin[i] == 'F') {
            endIdx -= ceil(((endIdx - stIdx) / 2))
        } else {
            stIdx += ceil(((endIdx - stIdx) / 2))
        }
    }

    val row = stIdx

    stIdx = 0.0
    endIdx = 8.0

    for(i in 7 until bin.length) {
        if(bin[i] == 'L') {
            endIdx -= ceil(((endIdx - stIdx) / 2))
        } else {
            stIdx += ceil(((endIdx - stIdx) / 2))
        }
    }
    return ((row * 8) + stIdx).toInt()
}

fun getOwnSeat(seatList: List<Int>) : Int {
    val min = seatList.min()!! - 1
    val max = seatList.max()!! + 1

    for(x in min..max) {
        if(!seatList.contains(x) && seatList.contains(x - 1) && seatList.contains(x + 1)) {
            return x
        }
    }
    return 0
}
