package collectionsnullability

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun sumNumberLines(reader: BufferedReader): List<Int?> {
    val resultList = ArrayList<Int?>()
    var number: Int
    for (line in reader.lineSequence()) {

        try {
            number = line.toInt()
            resultList.add(number)
        } catch (e: NumberFormatException) {
            resultList.add(null)
        }
    }
    return resultList
}

fun addValidNumbers(numberList: List<Int?>): Int {
    val validNumbers = numberList.filterNotNull()
    return validNumbers.sum()
}

fun countInvalidNumbers(numberList: List<Int?>): Int {
    return numberList.size - numberList.filterNotNull().size
}

fun main() {
    val file = File("src/collectionsnullability/Numbers.txt")
    val reader = BufferedReader(FileReader(file))
    val resultList = sumNumberLines(reader)
    println("Number List: $resultList")
    println("Sum of valid Numbers: ${addValidNumbers(resultList)}")
    println("Invalid numbers count: ${countInvalidNumbers(resultList)}")
}