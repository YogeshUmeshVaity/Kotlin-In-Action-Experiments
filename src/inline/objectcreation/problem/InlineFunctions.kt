package inline.problem

fun doSomething() {
    println("Before lambda")
    doSomethingElse {
        println("Inside lambda")
    }
    println("After lambda")
}

fun doSomethingElse(lambda: () -> Unit) {
    println("Doing something else")
    lambda()
}

fun main() {
    doSomething()
}