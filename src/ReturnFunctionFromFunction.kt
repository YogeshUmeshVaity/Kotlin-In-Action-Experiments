enum class Delivery { STANDARD, EXPEDITED }

data class Order(val itemCount: Int)

// Returns a function
fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if(delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order ->  2.1 * order.itemCount }
}

fun main() {
    val order = Order(7)

    // Get the function to calculate shipping cost
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)

    // Use the returned function
    val shippingCost = calculator(order)
    println("Shipping Cost: $shippingCost")
}