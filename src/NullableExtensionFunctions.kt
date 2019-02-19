// Rather than ensuring that the variable can't be null,
// you can allow with 'null' as a receiver and deal with 'null' in the function.
// In Java 'this' is always not-null, but in Kotlin, with extension functions,
// 'this' can be null. So you need to check for nullability inside the function.
// Now you can call this function on nullable values.
fun String?.isBlankOrNull(): Boolean {
    return this == null || this.isBlank()
}

fun verifyUserInput(name: String?) {
    if (name.isBlankOrNull()) {
        println("Please enter valid name")
    }
}

fun main() {
    val abcName = "abc"
    verifyUserInput(abcName)

    verifyUserInput(null)

    verifyUserInput(" ")
}