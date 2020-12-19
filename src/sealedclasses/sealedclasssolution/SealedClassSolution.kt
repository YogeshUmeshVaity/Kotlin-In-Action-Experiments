package sealedclasses.sealedclasssolution

/**
 * Restricted Class Hierarchy: sealed class
 *
 * Using the keyword sealed on a class does two things,
 * 1. It makes that class an abstract class.
 * 2. It makes it impossible to extend that class outside of that file.
 */
sealed class DeliveryStatus
object Preparing : DeliveryStatus()
class Dispatched(val trackingId: String) : DeliveryStatus()
class Delivered(val receiversName: String) : DeliveryStatus()

/**
 * Sealed Component/Restricted Polymorphism:
 * By passing the object of a sealed class to a function or any component, you are also making that
 * function sealed in a sense. For example, now our displayStatus() function is sealed for a limited
 * forms of objects, that is, it will either take Preparing, Dispatched or Delivered. Earlier it was
 * able to take any subclass of DeliveryStatus, no matter what file that subclass would be defined
 * in. The sealed modifier has put a limit on polymorphism.
 *
 * No else Branch:
 * Due to limited polymorphism, we don't need to worry about other possible subclasses
 * of DeliveryStatus and throw an exception when our function receives an unwanted type. As a result,
 * we don't need an else branch in the when expression.
 *
 * Exhaustive when expression:
 * Just like all the possible enum values of an enum class are contained inside the same class,
 * all the possible subtypes of a sealed class are contained inside the same file. So, when the
 * compiler comes across the sealed modifier, it knows that all the possible subclasses of this
 * sealed class are in the same file. This information helps the compiler to make sure that we have
 * covered(exhausted) all the possible subtypes in the when expression. And when we add a new
 * subclass to the same file and forget to cover it in the when expression, it flags an error. This
 * is what is called exhaustive when expression.
 *
 * IDE Support:
 * When you just type when (status) { } and press alt + enter, enter, the IDE automatically generates
 * all the possible branches for you like following:
 * when (status) {
 *     is Preparing -> TODO()
 *     is Dispatched -> TODO()
 *     is Delivered -> TODO()
 * }
 * In our small example there just 3 branches but in real world you could have 100s of branches, so
 * you save effort of manually looking up which subclasses you have defined in one file and writing them
 * in the when expression one by one in another file. Just use this IDE feature. Only sealed modifier
 * enables this feature.
 */
fun displayStatus(state: DeliveryStatus) {
    when (state) {
        is Preparing -> print("Preparing for Dispatch")
        is Dispatched -> print("Dispatched. Tracking ID: ${state.trackingId}")
        is Delivered -> print("Delivered. Received by ${state.receiversName}")
    }
}

fun main() {
    val preparing = Preparing
    val dispatched = Dispatched("5237")
    val delivered = Delivered("John")

    displayStatus(delivered)
}