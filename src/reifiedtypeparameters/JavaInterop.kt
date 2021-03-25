package reifiedtypeparameters.javainterop

inline fun <reified T> doSomething34(value: T) {
    println("Doing something with type: ${T::class.simpleName}")
}

class MyClass {
    inline fun <reified T> foo() {

    }
}
