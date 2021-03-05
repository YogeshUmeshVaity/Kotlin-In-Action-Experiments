package inline.variablecapturing.problem

fun doSomething() {
    val message = "Hello"                // Local variable
    doSomethingElse {
        println("$message from lambda")  // Variable capture
    }
}

/**
 * If you have many local variables used inside the lambda or calling the lambda in loop, passing of
 * every local variable through the constructor causes the extra memory overhead. Using the inline
 * function in this case helps a lot, since the variable is directly copied to the call-site.
 */
fun doSomethingElse(lambda: () -> Unit) {
    println("Doing something else")
    lambda()
}

fun main() {
    doSomething()
}