interface Processor<T> {
    fun process(something: String): T
}

// Unit is useful when you are overriding function that returns are generic parameter
// You can still use the function and return no value.
class NoResultProcessor : Processor<Unit> {
    override fun process(something: String): Unit {
        // Do do something
    }
}