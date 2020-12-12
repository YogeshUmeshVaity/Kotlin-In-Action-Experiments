package sealedclassvsenum.properties.sealedclass

sealed class DeliveryStatus
class Preparing() : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
class Delivered(val trackingId: String, val receiversName: String) : DeliveryStatus()

//fun doAction(action: PlantAction) {
//    when(action) {
//        is Watering -> println("Watering ${action.quantity} ml")
//        is Fertilizing -> println("Fertilizing with ${action.fertilizer}")
//        is Pruning -> println("Pruning")
//    }
//}

// Note that compiler won't show exhaustive error for RainWatering class because it's not inherited
// directly from the sealed class. Due to the same reason, we can declare the RainWatering class in
// any other file, it doesn't have to be in the same file.
/**
 * object vs type
 */
// class RainWatering(override val quantity: Int) : Watering(quantity) { } // Can extend the subtype of sealed class subtypes
// class RainWatering() : PlantAction() { } // Can extend the sealed class.

//fun main() {
//    val watering = Watering(250)
//    doAction(watering)
//
//    val fertilizing = Fertilizing("seaweed")
//    doAction(fertilizing)
//}