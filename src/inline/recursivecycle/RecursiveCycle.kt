package inline.recursivecycle

/**
 * Don't use inline for such recursive cycle.
 * This will result in a never ending cycle of the functions copying the code. The compiler gives
 * you an error: `The 'yourFunction()' invocation is a part of inline cycle`.
 */
// inline fun doFirstThing() { doSecondThing() }
// inline fun doSecondThing() { doThirdThing() }
// inline fun doThirdThing() { doFirstThing() }

fun main() {
    // doFirstThing()
}