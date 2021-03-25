package reifiedtypeparameters

inline fun <reified T> doSomething() {
    doSomethingElse<T>()   // Passing T as an argument
}

inline fun <reified T> doSomethingElse() { }