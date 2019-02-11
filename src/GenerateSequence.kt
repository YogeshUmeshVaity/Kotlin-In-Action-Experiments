import java.io.File

fun File.isInsideHiddenDirectory() =
        // Generate the sequence with the starting element('this' in this case) and
        // providing a way to get each subsequent element
        generateSequence(this) {it.parentFile}.any {it.isHidden}

fun main() {
    val file = File("/Users/svtk/.anydir/a.txt")
    println(file.isInsideHiddenDirectory())
}