data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(point: Point): Boolean {
    return point.x in upperLeft.x until lowerRight.x &&
            point.y in upperLeft.y until lowerRight.y
}

fun main() {
    val rectangle = Rectangle(Point(20, 40), Point(40, 30))
    println("Does rectangle contain the point[35, 35] ? : ${Point(35, 35) in rectangle}")

    val rectangle1 = Rectangle(Point(10, 20), Point(50, 50))
    println("Does rectangle1 contain the point[20, 30] ? : ${Point(20, 30) in rectangle1}")
}