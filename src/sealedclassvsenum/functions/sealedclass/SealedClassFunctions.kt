package sealedclassvsenum.functions.sealedclass

sealed class DeliveryStatus {
    fun expectedTime() {
        when (this) {
            is Preparing -> println("6 days")
            is Dispatched -> println("4 days")
            is Delivered -> println("0 days")
        }
    }
}

/**
 * In sealed classes we can have different functions for different subtypes. Here we have the function
 * cancelOrder() for Preparing, rejectDelivery() for Dispatched and returnItem() for Delivered. This makes
 * the intent clearer and makes the code more readable, also we have the option of not having the function,
 * in case we don't want to.
 */
class Preparing : DeliveryStatus() {
    fun cancelOrder() = println("Cancelled successfully")
}

class Dispatched : DeliveryStatus() {
    fun rejectDelivery() = println("Delivery rejected")
}

class Delivered : DeliveryStatus() {
    fun returnItem() = println("Return initiated")
}

class OrderManager {
    fun cancelOrder(status: DeliveryStatus) = when(status) {
        is Preparing -> status.cancelOrder()
        is Dispatched -> status.rejectDelivery()
        is Delivered -> status.returnItem()
    }

    //...
}

fun main() {
    val status = Dispatched()
    status.expectedTime()
    status.rejectDelivery()
}