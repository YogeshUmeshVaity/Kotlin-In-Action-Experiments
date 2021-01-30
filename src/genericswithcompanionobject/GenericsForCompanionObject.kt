package genericswithcompanionobject

/**
 * Companion objects are same as static members in Java. The T of Foo cannot be accessed inside the
 * companion object because it's a singleton. The companion object is shared across all instances of
 * Foo. So, for the Foo<String> or F<Int>, the companion object is the same.
 */
class Foo<T> {
    /* ... */
    companion object {
//      fun foo(args: List<T>) {
        fun <T> foo(args: List<T>) {
            /* ... */
        }
    }
}

fun main() {
    val instance = Foo<String>()
    Foo.foo(listOf<Int>())

}