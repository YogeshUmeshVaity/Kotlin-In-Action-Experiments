package sealedclassvsenum.numberofinstances.enum

/**
 * Since enum values are objects and not types, we cannot create multiple instances of them. For example,
 * DISPATCHED is an object, so, it can exist only as a single instance, we can't create more instances
 * from it.
 */
enum class DeliveryStatus(val trackingId: String?) {
    PREPARING(null),
    DISPATCHED("27211"),
    DELIVERED("27211"),
}

fun main() {
    // Single Instance
    val dispatched1 = DeliveryStatus.DISPATCHED           // OK

    // Multiple Instances
    // val dispatched2 = DeliveryStatus.DISPATCHED("45234")  // Error
}