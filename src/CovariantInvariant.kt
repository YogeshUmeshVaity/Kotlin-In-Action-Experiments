/**
 * Variance means a characteristic of an object about whether it is covariant, invariant or contravariant.
 * Covariant means a variation of some object. A different form of an object. That means the two objects have something in common.
 * Invariant means the opposite of the variant. The objects don't have anything in common.
 */

fun main() {
    /**
     * This works because the List<out E> is covariant on it's element type.
     * Because it's defined using 'out' that means List<Int> is a subtype of List<Number>.
     */
    val listOfAny: List<Number> = listOf<Int>(1, 2, 3)
    println(listOfAny)

    /**
     * This doesn't work because the MutableList<E> is invariant on it's element type.
     * This isn't defined using any bound, so MutableList<Int> is not a subtype of MutableList<Number>.
     * Even though the Int is a subtype of the Number.
     */
    // val mutableListOfAny: MutableList<Number> = mutableListOf<Int>(1, 2, 3)
    // println(mutableListOfAny)
}