package sealedclassvsenum.functions.enum

/**
 * Enums can have abstract functions as well as regular functions. But like properties, each enum value
 * also has to have the same function. In this example, we have an abstract function cancelOrder()
 * that we have to override in each enum value. That means, we can't have different functions for
 * different enum values.
 */
enum class DeliveryStatus {
    PREPARING {
        override fun cancelOrder() = println("Cancelled successfully")
    },
    DISPATCHED {
        override fun cancelOrder() = println("Delivery rejected")
    },
    DELIVERED {
        override fun cancelOrder() = println("Return initiated")
    };

    abstract fun cancelOrder()

    fun expectedTime() {
        when (this) {
            PREPARING -> println("6 days")
            DISPATCHED -> println("4 days")
            DELIVERED -> println("0 days")
        }
    }
}

class DeliveryManager {
    fun cancelOrder(status: DeliveryStatus) {
        status.cancelOrder()
    }
    //...
}

fun main() {
    val status = DeliveryStatus.DISPATCHED
    val manager = DeliveryManager()
    manager.cancelOrder(status)
}