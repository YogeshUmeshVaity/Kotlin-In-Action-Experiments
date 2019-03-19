import java.lang.StringBuilder

// Specifies how to transform each element through the transform function as parameter.
fun <T> Collection<T>.joinToString(prefix: String = "",
                                   separator: String = ", ",
                                   postfix: String = "",
                                   transform: (T) -> String = {it.toString()}): String {
    val sb = StringBuilder(prefix)
    for((index, element) in this.withIndex()) {
        if(index > 0) sb.append(separator)
        sb.append(transform(element))
    }
    sb.append(postfix)
    return sb.toString()
}

fun main() {
    val strings = listOf("One", "Two", "Three")

    println(strings.joinToString())

    println(strings.joinToString { it.toLowerCase() })

    println(strings.joinToString(
        prefix = "{ ",
        separator = " | ",
        postfix = " }",
        transform = { it.toUpperCase()}))
}