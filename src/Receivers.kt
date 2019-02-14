import java.lang.StringBuilder

fun alphabet(): String {
    val stringBuilder = StringBuilder()
    // Here stringBuilder is a receiver object. The receiver object becomes
    // an implicit 'this' inside the body of the function literal
    // so that you can access the members of that receiver object without any additional qualifiers,
    // or access the receiver object using a 'this' expression.
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        append("\nNow I know alphabets")
        this.toString()
    }
}

// The above function can me made more concise using the expression
// body syntax like following
fun alphabetConcise() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet using with()")
    toString()
}

// apply() works just like with() but it always returns the receiver object
fun alphabetUsingApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet using apply()")
}.toString()

fun main() {
    println(alphabet())
    println(alphabetConcise())
    println(alphabetUsingApply())
}