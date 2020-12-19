package sealedclasses.abstractclasssolution

/**
 * Unrestricted Class Hierarchy: abstract class
 *
 * Instead of managing all the states in a single class, we separate the states in different classes. We create a class hierarchy from an abstract class so that we can use polymorphism in our displayStatus() function.
 *
 * Now you can see that Preparing state doesn't have any properties, so we make it a singleton object
 * using the an object declaration.
 *
 * The trackingId is now only associated with the Dispatched state and receiversName is only associated with the Delivered state. This gets rid of null values.
 */
abstract class DeliveryStatus
object Preparing : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
class Delivered(val receiversName: String) : DeliveryStatus()

/**
 * Polymorphism allows an object to take many forms. In our example function displayStatus(),
 * the objects of type DeliveryStatus can take the forms Preparing, Dispatched and Delivered.
 * The function does the work of checking which form the object is currently in, using the is
 * operator and displays the respective state.
 *
 * Since we got rid of null values, we can be sure that our objects will always have some values. So
 * now we don't need to check for null values using elvis(?:) operator.
 *
 * Unrestricted Polymorphism:
 * By unrestricted polymorphism I mean that our function displayStatus() can be passed a value of
 * unlimited amount of subclasses of the DeliveryStatus. This means we have to take care of
 * unexpected states, in our example, we throw an exception.
 *
 * Need else branch:
 * Due to unrestricted polymorphism, we need an else branch to decide what to do when an unexpected
 * state is passed. If we use some default state instead of throwing an exception and then forget
 * to take care of any newly added subclass, then that default state will be displayed instead of the
 * state of the newly subclass.
 *
 * No exhaustive when expression:
 * Since the subclasses of an abstract class can exist in other files, the compiler doesn't know
 * all the possible subclasses of the abstract class. So it won't flag an error at compile time, if
 * we forget to take care of any newly created subclasses in the when expression. In that case, only
 * exception can help us. Unfortunately, we'll know only after the program crashes at runtime.
 */
fun displayStatus(state: DeliveryStatus) = when (state) {
    is Preparing -> print("Preparing for Dispatch")
    is Dispatched -> print("Dispatched. Tracking ID: ${state.trackingId}")
    is Delivered -> print("Delivered. Received by ${state.receiversName}")
    else -> throw IllegalStateException("Unexpected state passed to the function.")
}

fun main() {
    val preparing = Preparing
    val dispatched = Dispatched("5237")
    val delivered = Delivered("John")

    displayStatus(delivered)
}