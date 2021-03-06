package inline.reified

import kotlin.reflect.KClass

/**
 * While using generics in Kotlin, we can work with the object(value) of type T.
 */
fun <T> doSomething(value: T) {
    println("Doing something with value: $value")               // OK
}

/**
 * But we can't work with the type directly. This is because the type argument that we pass to the
 * function is erased at runtime. So, we cannot possibly know exactly which type we are dealing with.
 */
fun <T> doSomething1(value: T) {
    // Error: Cannot use 'T' as reified type parameter. Use a class instead.
//  println("Doing something with type: ${T::class.simpleName}")     // Error
}

/**
 * The work around for this in Java was to pass an additional argument specifying the type.
 * This way our code is not affected by type erasure. But this solution is verbose and not very elegant.
 */
fun <T: Any> doSomething4(value: T, type: KClass<T>) {
    println("Doing something with type: ${type.simpleName}")  // OK
}

/**
 * Inline functions in Kotlin allow us to use the type when we mark the type parameter as a reified.
 * This becomes possible due to the fact inline functions copy the code at call-site. The type
 * parameter that we specify is also copied.
 */
inline fun <reified T> doSomething3(value: T) {
    println("Doing something with type: ${T::class.simpleName}")    // OK
}

fun main() {
    println("Doing something with type: ${String::class.simpleName}")

}