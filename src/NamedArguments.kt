import java.lang.StringBuilder

fun <T> joinToString(collection: Collection<T>,
                     prefix: String = "",
                     separator: String = ", ",
                     postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    println(joinToString(collection = listOf(1, 2, 3), prefix = "*", separator = ", ", postfix = "*"))
    println(joinToString(collection = listOf(1, 2, 3)))
    println(joinToString(collection = listOf(1, 2, 3), prefix = "#"))
}