data class NameComponents(val fileName: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    // Collections and Arrays support destructuring up to first five elements
    val (fileName, extension) = fullName.split(".", limit = 2)
    return NameComponents(fileName, extension)
}

// Use Destructuring to get info from collections inside loop
fun printStudentInfo(students: List<Student>) {
    for ((name, rollNumber) in students) {
        println("$name: $rollNumber")
    }
}

fun main() {
    val (fileName, extension) = splitFileName("String.kt")
    println("File name: $fileName, Extension: $extension")

    val sandy = Student("Sandy", 30)
    val (name, rollNumber) = sandy
    println("Name: $name, RollNumber: $rollNumber")

    val monty = Student("Monty", 40)
    printStudentInfo(listOf(sandy, monty))
}