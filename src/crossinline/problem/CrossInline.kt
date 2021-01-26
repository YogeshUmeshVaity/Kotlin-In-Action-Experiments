package crossinline.problem

/*
return statement without any label is considered a non-local return in Kotlin, in this case the return
statement will the execution of not only the doSomethingElse() function but also the doSomething()
function.
 */
fun doSomething() {
    println("Before lambda")
    doSomethingElse {
        println("Inside lambda")
//      return // Non-local return allowed
        return@doSomethingElse // Local-return allowed
    }
    println("After lambda")
}

inline fun doSomethingElse(lambda: () -> Unit) {
    println("Do something else")    // Do something else
    lambda()                        // then call lambda
    println("After do something else")
}

/*
Compiles to:

public static final void doSomething() {
    System.out.println("Before lambda");
    System.out.println("Doing something else");
    System.out.println("Inside lambda");
}

*/

fun main() {
    doSomething()
}

