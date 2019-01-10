fun main(args: Array<String>) {
    parsePath("MyComputer/Documents/Kotlin/Regex.doc")
}

// Directory structure : MyComputer/Documents/Kotlin/Regex.doc

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory\nFilename: $fileName\nExtension: $extension")
    }
}

