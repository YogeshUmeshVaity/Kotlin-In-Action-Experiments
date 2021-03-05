package inline.objectcreation.solution

fun doSomething() {
    println("Before lambda")
    doSomethingElse {
        println("Inside lambda")
    }
    println("After lambda")
}

/**
In JVM, a lambda or function type is converted to a class after compilation.
 */
inline fun doSomethingElse(lambda: () -> Unit) {
    println("Doing something else")
    lambda()
}

fun main() {
    doSomething()
}