package sealedclassvsenum.inheritance.enum

enum class DeliveryStatus1 {
    PREPARING,
    DISPATCHED,
    DELIVERED,
}

/**
 * Since enum values are objects they cannot be extended.
 */
// class LocallyDispatched : DeliveryStatus.DISPATCHED { }    // Error

/**
 The enum class is implicitly final, so it cannot be extended by other classes.
 */
// class FoodDeliveryStatus : DeliveryStatus() { }    // Error

/**
 * Enums cannot extend other classes, they can only extend interfaces.
 */
open class OrderStatus { }
interface Cancellable2 { }
// enum class DeliveryStatus2 : OrderStatus() { }    // Error
enum class DeliveryStatus3 : Cancellable2 { }     // OK

/**
 * Enums cannot extend other classes, only interfaces
 */
interface Cancellable {
    fun cancelOrder()
}

enum class DeliveryStatus : Cancellable {
    PREPARING {
        override fun cancelOrder() = println("Cancelled successfully")
    },
    DISPATCHED {
        override fun cancelOrder() = println("Already dispatched")
    },
    DELIVERED {
        override fun cancelOrder() = println("Already delivered")
    };
}

enum class FoodDeliveryStatus : Cancellable {
    COOKING {
        override fun cancelOrder() = println("Cancelled successfully")
    },
    ARRIVING {
        override fun cancelOrder() = println("Already in transit")
    },
    RECEIVED {
        override fun cancelOrder() = println("Already received")
    }
}

/**
 * The advantage of extending an interface in an enum is that we can have a reusable class like this.
 * It can take unlimited number of enums that are extended from a common interface.
 * We can keep the extended enums in other files unlike sealed classes that need to be in the same file.
 */
class OrderManager(private val cancellable: Cancellable) {
    fun cancel() {
        cancellable.cancelOrder()
    }

    //...
}

fun main() {
    val shippingOrderManager = OrderManager(DeliveryStatus.PREPARING)
    shippingOrderManager.cancel()

    val foodOrderManager = OrderManager(FoodDeliveryStatus.RECEIVED)
    foodOrderManager.cancel()
}