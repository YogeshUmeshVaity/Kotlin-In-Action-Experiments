package sealedclasses.taggedclassproblem

import sealedclasses.taggedclassproblem.DeliveryStatus.Type.*

/**
 * Problems:
 * 1. The class has multiple responsibilities of representing different states. The class represents three
 * different delivery states PREPARING, DISPATCHED and DELIVERED.
 *
 * 2. Different properties are used for different kinds of states. For example, we don't need any property for
 * representing the PREPARING state. The trackingId property is used only for the DISPATCHED state and the
 * receiversName property is concerned only with the DELIVERED state. This means an object will have more
 * properties than it actually needs to represent a particular state. For example, for the DISPATCHED state,
 * the receiversName property won't be used.
 *
 * 3. Since these unused variables can be set from unrelated states, it's hard to guarantee the consistency of
 * a particular state. For example, one can set the receiversName property on the PREPARING state. In that case
 * the PREPARING will be an illegal state.
 */
class DeliveryStatus(
    val type: Type,
    val trackingId: String? = null,
    val receiversName: String? = null
) {
    enum class Type { PREPARING, DISPATCHED, DELIVERED }

    // Problem: Have to use factory methods to ensure that the object are created properly.
    companion object {
        fun preparing() = DeliveryStatus(PREPARING)
        fun dispatched(trackingId: String) = DeliveryStatus(DISPATCHED, trackingId)
        fun delivered(trackingId: String, receiversName: String) =
            DeliveryStatus(DELIVERED, trackingId, receiversName)
    }
}

// Enums act like type marker. We get exhaustive when, thanks to enums. So it's not like the sole purpose of
// sealed classes is to have exhaustive when.
// Problem: We have to check for null values and throw exception. The error() function is a Kotlin standard
// library function that throws IllegalStateException.
fun checkStatus(status: DeliveryStatus) = when (status.type) {
    PREPARING -> println("Preparing to dispatch")
    DISPATCHED -> println("Dispatched. Tracking ID: ${status.trackingId ?: "unavailable"}")
    DELIVERED -> println("Delivered. Receiver's name: ${status.receiversName ?: "unavailable"}")
}

fun main() {
    // Problem: Instantiation process is messy.
    // You can see while instantiating how the states are mixed with each other.
    // Also forced null values.
//    val preparing = DeliveryStatus(PREPARING, null, null)
//    val dispatched = DeliveryStatus(DISPATCHED, "5237", null)
//    val delivered = DeliveryStatus(DELIVERED, "5237", "John")

    val preparing = DeliveryStatus.preparing()
    val dispatched = DeliveryStatus.dispatched("5237")
    val delivered = DeliveryStatus.delivered("5237","John")

    checkStatus(delivered)
}