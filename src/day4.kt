import java.io.File

fun main() {
    val passportList = arrayListOf<String>()

    File("src/files/day4.txt").forEachLine {
        passportList.add(it)
    }

    println("The result is: " + countPassports(passportList))
}

fun countPassports(passportList: List<String>): Int {
    var result = 0
    val passportMap = mutableMapOf<String, String>()

    for (x in passportList.indices) {
        if (!passportList[x].isBlank()) {
            val dataSplit = passportList[x].split(" ")

            dataSplit.forEach {
                passportMap.put(
                    it.replaceAfter(":", "").replace(":", ""),
                    it.replaceBefore(":", "").replace(":", "")
                )
            }
        }

        if (passportList[x] == "" || x == passportList.size - 1) {
            if ((passportMap.containsKey("byr") && byrValid(passportMap["byr"]))
                && (passportMap.containsKey("iyr") && iyrValid(passportMap["iyr"]))
                && (passportMap.containsKey("eyr") && eyrValid(passportMap["eyr"]))
                && (passportMap.containsKey("hgt") && hgtValid(passportMap["hgt"]))
                && (passportMap.containsKey("hcl") && hclValid(passportMap["hcl"]))
                && (passportMap.containsKey("ecl") && eclValid(passportMap["ecl"]))
                && (passportMap.containsKey("pid") && pidValid(passportMap["pid"]))
            ) {
                result++
            }

            passportMap.clear()
        }
    }
    return result
}

fun byrValid(byr: String?): Boolean {
    return byr?.toInt() ?: 0 in 1920..2002
}

fun iyrValid(iyr: String?): Boolean {
    return iyr?.toInt() ?: 0 in 2010..2020
}

fun eyrValid(eyr: String?): Boolean {
    return eyr?.toInt() ?: 0 in 2020..2030
}

fun hgtValid(hgt: String?): Boolean {
    if (hgt!!.endsWith("cm")) {
        return hgt.replace("cm", "").toInt() in 150..193
    } else if (hgt.endsWith("in")) {
        return hgt.replace("in", "").toInt() in 59..76
    }
    return false
}

fun hclValid(hcl : String?) : Boolean {
    return hcl!!.matches(Regex("#[0-9a-f]{6}"))
}

fun eclValid(ecl: String?) : Boolean {
    return ecl == "amb" || ecl == "blu" || ecl == "brn" || ecl == "gry" ||
            ecl == "grn" || ecl == "hzl" || ecl == "oth"
}

fun pidValid(pid: String?) : Boolean {
    return pid!!.matches(Regex("[0-9]{9}"))
}