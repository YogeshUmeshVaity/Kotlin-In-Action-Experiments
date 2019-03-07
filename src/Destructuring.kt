data class NameComponents(val fileName: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    // Collections and Arrays support destructuring up to first five elements
    val (fileName, extension) = fullName.split(".", limit = 2)
    return NameComponents(fileName, extension)
}

fun main() {
    val (fileName, extension) = splitFileName("String.kt")
    println("File name: $fileName, Extension: $extension")

    val student = Student("Sandy", 30)
    val (name, rollNumber) = student
    println("Name: $name, RollNumber: $rollNumber")
}