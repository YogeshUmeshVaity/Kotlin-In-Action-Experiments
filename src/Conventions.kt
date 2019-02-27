data class Point(val x: Int, val y: Int) {
    // Under the hood, the plus() function is called as:     a + b => a.plus(b)
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// You can define the operator as an extension function as well, the result is the same.
// It's a common pattern to use convention extension functions for external library classes.
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

// The return type can also be different from the two operand types
operator fun Char.times(count: Int): String {
    return this.toString().repeat(count)
}

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    println("+= called")
    this.add(element)
}

fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(30, 40)
    // You can sum up your objects using the + sign
    println(point1 + point2)

    val point = Point(15, 40)
    // The operand objects don't have to be of same type.
    println(point * 1.5)

    println('a' * 3)

    // Mutable collection
    val mutableList = arrayListOf(1, 2)
    // Modifies mutable collection, in place. No new copy.
    mutableList += 3
    println(mutableList)

    // Read-only collection
    val readOnlyList = listOf(4, 5)
    // readOnlyList += 6    // <= Error: val cannot be reassigned
    // If you want to add element to read-only collection do it like following or
    // declare above variable as var
    val newList = readOnlyList + 6
    println(newList)

    // Add lists
    println(mutableList + readOnlyList)
}