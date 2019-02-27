data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

fun main() {
    val point1 = Point(10, 20)
    val point2 = Point(30, 40)
    println(point1 + point2)
}