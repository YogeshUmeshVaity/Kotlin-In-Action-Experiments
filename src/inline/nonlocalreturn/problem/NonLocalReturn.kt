package inline.nonlocalreturn.problem

/**
 * Since non-inline function type is converted to a class, we can't write the return statement
 * inside the lambda.
 *
 * This is known as non-local return because it's not local to the calling function doSomething().
 * The reason for not allowing the non-local return is that the return statement exists in another
 * class (in the anonymous class shown previously).
 */
fun doSomething() {
    doSomethingElse {
//      return@doSomething      // return is not allowed here
    }
}

fun doSomethingElse(lambda: () -> Unit) {
    lambda()
}

fun main() {
    doSomething()
}