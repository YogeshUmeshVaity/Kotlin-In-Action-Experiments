package crossinline.solution

fun doSomething() {
    println("Before lambda")
    doSomethingElse {
        println("Inside lambda")
//      return                  // Error: non-local return not allowed
        return@doSomethingElse  // OK: local return allowed
    }
    println("After lambda")
}

inline fun doSomethingElse(crossinline lambda: () -> Unit) {
    println("Doing something else")    // Do something else
    lambda()                           // then call lambda
}

/*
Compiles to:

public static final void doSomething() {
    System.out.println("Before lambda");
    System.out.println("Doing something else");
    System.out.println("Inside lambda");
    System.out.println("After lambda");
}

 */

fun main() {
    doSomething()
}