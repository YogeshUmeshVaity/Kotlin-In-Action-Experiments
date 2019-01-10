// Directory structure : MyComputer/Documents/Kotlin/Regex.doc
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val FullFileName = path.substringAfterLast("/")
    val fileName = FullFileName.substringBeforeLast(".")
    val extension = path.substringAfterLast(".")
    println("Dir: $directory \nFilename: $fileName \nExtension: $extension")
}

fun main(args: Array<String>) {
    parsePath("MyComputer/Documents/Kotlin/Regex.doc")
}