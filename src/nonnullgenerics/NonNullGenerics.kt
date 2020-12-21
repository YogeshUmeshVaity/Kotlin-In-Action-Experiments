package nonnullgenerics

/**
 * Nullable Generic Type : Default
 */
class Test<T : Any?> {
    // private lateinit var t : T     // T is nullable
}

/**
 * Non-null Generic Type : Explicit
 */
class Test1<T : Any> {
    private lateinit var t: T      // T is non-null
    private var t2: T? = null    // T can be used as nullable
}

fun main() {
    val test: Test<Int> = Test()    // OK
    val test2: Test<Int?> = Test()  // OK

    val test3: Test1<Int> = Test1()  // OK
//     val test4: Test1<Int?> = Test1() // Error: nullable not allowed
}