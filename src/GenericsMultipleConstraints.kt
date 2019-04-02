import java.lang.StringBuilder

/**
 * Define multiple constraints(Charsequence and Appendable) on the type parameter.
 * In other words, it defines multiple upper bounds for type parameter T.
 */
fun <T> ensureTrailingPeriod(sequence: T) where T : CharSequence, T : Appendable {
    if(!sequence.endsWith('.')) {   // Accesses extension function defined for the Charsequence
        sequence.append('.')        // Accesses method defined in Appendable
    }
}

fun main() {
    val helloworld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloworld)
    println(helloworld)
}