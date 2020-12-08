package sealedclassvsenum.inheritance.sealedclass

open class OrderStatus { }

/**
 * Sealed class can extended from other classes and interfaces.
 */
sealed class DeliveryStatus : OrderStatus() { }
open class Preparing : DeliveryStatus()
open class Dispatched : DeliveryStatus()
open class Delivered : DeliveryStatus()

// This can be in different file too because it's not directly inherited from the sealed class.
class LocallyDispatched : Dispatched() { }    // OK

// Can be extended of course
class PaymentReceived : DeliveryStatus()      // OK

// Sealed classes can extend other classes as well as interfaces
open class OrderStatus1 { }
interface Cancellable { }
sealed class DeliveryStatus1 : OrderStatus() { }    // OK
sealed class DeliveryStatus2 : Cancellable { }    // OK