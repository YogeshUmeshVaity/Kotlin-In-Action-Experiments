import java.lang.StringBuilder

// Define function filter() that takes another function 'predicate' as a parameter
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for(index in 0 until length) {
        val element = get(index)
        if(predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun main() {
    // Call the function with lambda(function) as an argument
    val result = "ab1c".filter {it in 'a'..'z'}
    println(result)
}