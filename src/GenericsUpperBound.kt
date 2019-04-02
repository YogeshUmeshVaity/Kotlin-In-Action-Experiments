// Invokes a method defined in the Number class.
fun <T : Number> oneHalf(number: T) : Double {
    return number.toDouble() / 2.0
}

fun main() {
    println(oneHalf(9))
}