package inline.nonlocalreturn.solution

fun doSomething() {
    doSomethingElse {
        println("Inside lambda")
        return      // return is not allowed here
    }
}

/**
 * Making the doSomethingElse() function inline solves this problem and we are allowed to use
 * non-local returns because then the return statement is copied inside the calling function.
 */
inline fun doSomethingElse(lambda: () -> Unit) {
    println("Doing something else")
    lambda()
}

fun main() {
    doSomething()
}