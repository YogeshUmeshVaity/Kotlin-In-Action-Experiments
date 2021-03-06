/**
 * You can use normal generic types in 'as' and 'as?' casts.
 * But cast won't fail, if the class has the correct base type and a wrong type argument.
 * In example below, the Collection will be casted to List but not necessarily to List<Int>.
 * Because the type argument is not known at runtime when the cast is performed as it is erased.
 */
fun sumSequence(sequence: Collection<*>): Int {     // Unknown type argument
    val intList = sequence as? List<Int> ?: throw IllegalArgumentException("Required List of Int")
    return intList.sum()
}

// The cast without warning is possible because you know at compile time that this collection
// contains integer numbers.
fun sumSeqOfInt(sequence: Collection<Int>): Int {   // Known type argument
    val intList = sequence as List<Int>
    return intList.sum()
}

fun main() {
    // Works as expected
    println(sumSequence(listOf(1, 2, 3)))

    // Casts it to List successfully but when doing sum() operation classCastException occurs.
    println(sumSequence(listOf("ab", "xy", "pq")))

    // Cast fails because it is Set and not a List
    println(sumSequence(setOf(1, 2, 3)))
}