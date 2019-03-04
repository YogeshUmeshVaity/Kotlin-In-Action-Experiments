data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, coordinate: Int) {
    when(index) {
        0 -> x = coordinate
        1 -> y = coordinate
    }
}

fun main() {
    val point = MutablePoint(10, 30)
    println("Initial point: $point")

    point[0] = 20
    println("Modified point: $point")
}