package starprojection

/**
 * Kotlin forces you to specify a type argument when you are using or instantiating a generic type.
 * So, you must specify a type argument. But type arguments are erased at runtime.
 * To overcome this, you use star projection syntax.
 */
fun main() {
    val collection = listOf("abc")

//  if (collection is Set<Any>) { }       // Error: Erased type
//  if (collection is Set) { }            // Error: Must specify type argument
    if (collection is Set<*>) { }         // OK:    Star projection to the rescue

    /**
     * So you are saying to the compiler that I know it's a set but I don't know what type of
     * objects it contains.
     */
}