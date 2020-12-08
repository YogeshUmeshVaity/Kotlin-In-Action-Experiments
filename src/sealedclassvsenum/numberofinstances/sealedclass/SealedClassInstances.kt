package sealedclassvsenum.numberofinstances.sealedclass

/**
 * Subtypes of sealed classes are types, so, we can create multiple instances of these types.
 * We can also make a type to have only a single instance using an object declaration.
 *
 * In this example, Preparing can can have only a single object, just like an enum value.
 *
 * Notice also that we have utilised the ability of the subtypes of sealed classes to be as
 * a singleton object, a regular class or a data class.
 */
sealed class DeliveryStatus
object Preparing : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
data class Delivered(val receiversName: String) : DeliveryStatus()

fun main() {
    val dispatched1 = Dispatched("27211")  // OK
    val dispatched2 = Dispatched("45234")  // OK

    val preparing1 = Preparing             // OK
//  val preparing2 = Preparing()           // Error
}