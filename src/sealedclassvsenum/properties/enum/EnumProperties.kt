package sealedclassvsenum.properties.enum

// Properties
// Methods
// Classes: object, regular class, data class
// Inheritance
// Can create many instances(sealed) vs Single instance(enum)
// Performance
/**
 * Property: You are forced to have a property for each enumerated type. For example, here we need the trackingId
 * only for the DISPATCHED and DELIVERED, the PREPARING is forced to have a null value.
 */
enum class DeliveryStatus(val trackingId: String?) {
    PREPARING(null),
    DISPATCHED("27211"),
    DELIVERED("27211"),
}

/**
 * object vs type
 */
// class RainWatering : PlantAction.WATERING { }   // Can't extend an enum entry.
// class RainWatering(override val quantity: Int?) : PlantAction(quantity) { }   // Can't extend the enum class. Error: This type is final


/**
 * Closed set nature:
 * Enums and sealed classes allow us to represent a closed set of possible subtypes that can be
 * associated with a given type. In this function, by having an enum as a parameter, we are limiting
 * the subtypes of AuthenticationStatus the function can accept.
 * The function cannot accept any subtype but only those defined in the
 * enum class AuthenticationStatus. This means we are accepting closed set of possible subtypes.
 * Due to closed set nature, the compiler can ensure that we handled all possibilities.
 */
//fun showStatus(status: AuthenticationStatus) {
//    when(status) {
//        AuthenticationStatus.AUTHENTICATED -> println("${status.user} is logged in.")
//        AuthenticationStatus.UNAUTHENTICATED -> println("Not logged in")
//        AuthenticationStatus.PROCESSING -> println("Logging in please wait")
//    }
//}

//fun main() {
//    // Has to be called with enum type not with the enum class.
//    PlantAction.WATERING.doAction(PlantAction.FERTILIZING)
//
//    // Can be called directly
//    doAction(PlantAction.WATERING)
//}