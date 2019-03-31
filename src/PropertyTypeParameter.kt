/**
 * You can declare parameter types for extension properties.
 * This is not possible for regular properties of a class.
 */
val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println("The element before the last one: ${numbers.penultimate}")
}